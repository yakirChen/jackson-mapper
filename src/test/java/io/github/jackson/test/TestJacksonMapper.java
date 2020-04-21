package io.github.jackson.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.truth.Truth;
import io.github.yakirchen.jackson.Jackson;
import io.github.yakirchen.jackson.JacksonMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TestJacksonMapper
 *
 * @author yakir <a href="https://yakirchen.github.io">yakirchen.github.io</a> on 2018/10/12 23:06.
 */
public class TestJacksonMapper {

    private static final Logger log = LogManager.getLogger(TestJacksonMapper.class);

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss SSSSSS";

    private void testJacksonMapperBuild() {

        JacksonMapper jacksonMapper = Jackson.builder()
                .snakeCase()
                .upperCamelCase()
                .lowerCamelCase()
                .lowerCase()
                .disableFailOnEmptyBeans()
                .disableFailOnUnknownProperties()
                .disableOnIgnoredProperties()
                .disableWriteDatesAsTimestamps()
                .defaultDateFormat(DATE_PATTERN)
                .addJavaTimeModule(DATE_PATTERN)
                .build();

        List<String> hobby = new ArrayList<String>() {
            private static final long serialVersionUID = 1372828590201410789L;
            {
                add(".");
                add("..");
                add("...");
                add("....");
                add(".....");
                add("......");
                add(".......");
            }
        };

        Bar bar = new Bar()
                .setBar("bar")
                .setBarCdate(new Date())
                .setBarId((long) Integer.MAX_VALUE);
        Foo foo = new Foo(
                Long.MAX_VALUE,
                LocalDateTime.now(),
                hobby,
                bar
        );

        String json = jacksonMapper.defaultPrettyPrinter(foo);
        log.info(json);
        String json0 = jacksonMapper.withPrettyPrinter(foo);
        log.info(json0);
        Foo foo0 = jacksonMapper.readValue(json, new TypeReference<Foo>() {});

        Truth.assertThat(foo0.getFooCdate()).isEqualTo(foo.getFooCdate());
        Truth.assertThat(foo0.getFooId()).isEqualTo(foo.getFooId());
        Truth.assertThat(foo0.getHobby()).isEqualTo(foo.getHobby());

        Foo foo1 = jacksonMapper.readValue(json, new TypeReference<Foo>() {});
        Truth.assertThat(foo1.getFooCdate()).isEqualTo(foo.getFooCdate());
        Truth.assertThat(foo1.getFooId()).isEqualTo(foo.getFooId());
        Truth.assertThat(foo1.getHobby()).isEqualTo(foo.getHobby());
    }


    private void testEnableFeature() {
        String json = "{// comments \n\"name\"// comments \n: 'yakirChen','name0'// comments \n: 'yakirChen0'}";
        JacksonMapper jacksonMapper = Jackson.builder()
                .allowComments()
                .allowSingleQuote()
                .build();

        Map<String, String> obj = jacksonMapper.readValue(json, new TypeReference<Map<String, String>>() {});

        Truth.assertThat(obj.get("name")).isEqualTo("yakirChen");
        Truth.assertThat(obj.get("name0")).isEqualTo("yakirChen0");
    }

    @Test
    public void test_00() {

        try {

            TestJacksonMapper testJacksonMapper = new TestJacksonMapper();
            testJacksonMapper.testJacksonMapperBuild();

        } catch (Throwable thr) {
            log.error("Err:", thr);
        }

    }

    @Test
    public void test_01() {

        try {

            TestJacksonMapper testJacksonMapper = new TestJacksonMapper();
            testJacksonMapper.testEnableFeature();

        } catch (Throwable thr) {
            log.error("Err:", thr);
        }

    }
}

