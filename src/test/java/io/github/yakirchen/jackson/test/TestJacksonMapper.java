package io.github.yakirchen.jackson.test;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.yakirchen.jackson.JacksonMapper;
import io.github.yakirchen.jackson.JacksonMapperBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
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

        Assertions.assertEquals(foo0.getCdate(), foo.getCdate());
        Assertions.assertEquals(foo0.getId(), foo.getId());
        Assertions.assertEquals(foo0.getHobby(), foo.getHobby());
    }

    @Test
    public void testEnableFeature() {
        String json = "{// comments \n\"name\"// comments \n: 'yakirChen','name0'// comments \n: 'yakirChen0'}";
        JacksonMapper jacksonMapper = new JacksonMapperBuilder()
                .allowComments()
                .allowSingleQuote()
                .build();

        Map<String, String> obj = jacksonMapper.readValue(json,
                new TypeReference<Map<String, String>>() {});

        Assertions.assertEquals(obj.get("name"), "yakirChen");
        Assertions.assertEquals(obj.get("name0"), "yakirChen0");
    }
}

