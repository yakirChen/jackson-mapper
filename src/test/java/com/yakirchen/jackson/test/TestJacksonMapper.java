package com.yakirchen.jackson.test;

import com.yakirchen.jackson.JacksonMapper;
import com.yakirchen.jackson.JacksonMapperBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * TestJacksonMapper
 *
 * @author yakir <a href="yakirchen.com">yakirchen.com</a> on 10/25/2018 23:06.
 */
public class TestJacksonMapper {

    private static final Logger logger = LoggerFactory.getLogger(TestJacksonMapper.class);

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
                .seDateTimeFormatterPattern("yyyy-MM-dd HH:mm:ss SSS")
                .deDateTimeFormatterPattern("yyyy-MM-dd HH:mm:ss SSS")
                .dateFormat("yyyy-MM-dd HH:mm:ss SSS")
                .build();

        List<String> hobby = new ArrayList<>(1);
        hobby.add(".");
        hobby.add("..");
        hobby.add("...");
        hobby.add("....");

        Foo foo = new Foo(Long.MAX_VALUE,
                LocalDateTime.now(),
                hobby);

        String json = jacksonMapper.defaultPrettyPrinter(foo);
        logger.info(json);
        Foo foo0 = jacksonMapper.readValue(json, Foo.class);

        Assertions.assertEquals(foo0.getCdate(), foo.getCdate());
        Assertions.assertEquals(foo0.getId(), foo.getId());
        Assertions.assertEquals(foo0.getHobby(), foo.getHobby());
    }
}

