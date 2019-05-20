package io.github.yakirchen.jackson.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.truth.Truth;
import io.github.yakirchen.jackson.JacksonMapper;
import io.github.yakirchen.jackson.JacksonMapperBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TestJacksonMapper
 *
 * @author yakir <a href="https://yakirchen.github.io">yakirchen.github.io</a> on 2018/10/12 23:06.
 */
public class TestJacksonMapper {

    private static final Logger logger = LoggerFactory.getLogger(TestJacksonMapper.class);

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss SSS";

    public void testJacksonMapperBuild() {

        JacksonMapper jacksonMapper = new JacksonMapperBuilder()
                .snakeCase()
                .upperCamelCase()
                .lowerCamelCase()
                .lowerCase()
                .kebabCase()
                .deDisableFailOnUnknowPropertis()
                .deDisableFailOnIgnoredProperties()
                .seDisableDatesAsTimestamps()
                .seDisableFailOnEmptyBeans()
                .seDateTimeFormatterPattern(DATE_PATTERN)
                .deDateTimeFormatterPattern(DATE_PATTERN)
                .dateFormat(DATE_PATTERN)
                .build();

        List<String> hobby = new ArrayList<>(1);
        hobby.add(".");
        hobby.add("..");
        hobby.add("...");
        hobby.add("....");

        Foo foo = new Foo(
                Long.MAX_VALUE,
                LocalDateTime.now(),
                hobby
        );

        String json = jacksonMapper.defaultPrettyPrinter(foo);
        logger.info(json);
        Foo foo0 = jacksonMapper.readValue(json, Foo.class);

        Truth.assertThat(foo0.getCdate()).isEqualTo(foo.getCdate());
        Truth.assertThat(foo0.getId()).isEqualTo(foo.getId());
        Truth.assertThat(foo0.getHobby()).isEqualTo(foo.getHobby());
    }

    public void testEnableFeature() {
        String json = "{// comments \n\"name\"// comments \n: 'yakirChen','name0'// comments \n: 'yakirChen0'}";
        JacksonMapper jacksonMapper = new JacksonMapperBuilder()
                .allowComments()
                .allowSingleQuote()
                .build();

        Map<String, String> obj = jacksonMapper.readValue(json,
                new TypeReference<Map<String, String>>() {});

        Truth.assertThat(obj.get("name")).isEqualTo("yakirChen");
        Truth.assertThat(obj.get("name0")).isEqualTo("yakirChen0");
    }


    public static void main(String[] args) {

        TestJacksonMapper testJacksonMapper = new TestJacksonMapper();
        testJacksonMapper.testEnableFeature();
        testJacksonMapper.testJacksonMapperBuild();
    }
}

