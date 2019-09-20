package io.github.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * JacksonMapper
 *
 * @author yakir <a href="https://yakirchen.github.io">yakirchen.github.io</a> on 2018/07/12 15:05.
 */
public class JacksonMapperBuilder {

    private static final Logger log = LogManager.getLogger(JacksonMapperBuilder.class);

    private final JacksonMapper mapper;

    public JacksonMapperBuilder() {
        this.mapper = new JacksonMapper();
    }

    /**
     * 允许JSON中包含注释
     *
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder allowComments() {
        this.mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
        return this;
    }

    /**
     * 允许Json中使用单引号
     *
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder allowSingleQuote() {
        this.mapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        return this;
    }

    /// format local date / local date time ---------------------------------------------

    public JacksonMapperBuilder dateFormat(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        this.mapper.setDateFormat(sdf);
        return this;
    }

    /// PropertyNamingStrategy ----------------------------------------------------------

    /**
     * 驼峰转小写下划线
     *
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder snakeCase() {
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return this;
    }

    /**
     * 首字母大写驼峰
     *
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder upperCamelCase() {
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return this;
    }

    /**
     * 首字母小写驼峰
     *
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder lowerCamelCase() {
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        return this;
    }

    /**
     * 驼峰转全小写(没有驼峰)
     *
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder lowerCase() {
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);
        return this;
    }

    /**
     * 驼峰转分隔符, 类似于下划线(下划线变成了分隔符)
     *
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder kebabCase() {
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
        return this;
    }

    /// DeserializationFeature ----------------------------------------------------------

    public JacksonMapperBuilder deDisableFailOnUnknowPropertis() {
        this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return this;
    }

    public JacksonMapperBuilder deDisableFailOnIgnoredProperties() {
        this.mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        return this;
    }

    /// SerializationFeature ------------------------------------------------------------

    public JacksonMapperBuilder seDisableDatesAsTimestamps() {
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return this;
    }

    public JacksonMapperBuilder seDisableFailOnEmptyBeans() {
        this.mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return this;
    }

    /**
     * 注册 LocalDateTime
     *
     * @param pattern 时间格式表达式
     * @return JacksonMapperBuilder
     */
    public JacksonMapperBuilder registerLocalDateTime(String pattern) {
        JavaTimeModule    jtm = new JavaTimeModule();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        jtm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dtf));
        jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dtf));
        this.mapper.registerModule(jtm);
        return this;
    }

    /**
     * build
     *
     * @return JacksonMapper
     */
    public JacksonMapper build() {
        return this.mapper;
    }
}
