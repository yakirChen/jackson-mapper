package io.github.yakirchen.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Jackson
 *
 * @author yakir <a href="https://yakirchen.github.io">yakirchen.github.io</a> on 2018/07/12 15:05.
 */
public class Jackson {

    public static Builder builder() {
        return new Builder(new JacksonMapper());
    }

    public static class Builder extends MapperBuilder<JacksonMapper, Builder> {

        public Builder(JacksonMapper m) {
            super(m);
        }

        /**
         * 允许JSON中包含注释
         *
         * @return Builder
         */
        public Builder allowComments() {
            _mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
            return this;
        }

        /**
         * 允许Json中使用单引号
         *
         * @return Builder
         */
        public Builder allowSingleQuote() {
            _mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            return this;
        }

        /// format local date / local date time ---------------------------------------------

        public Builder defaultDateFormat(String pattern) {
            this.defaultDateFormat(new SimpleDateFormat(pattern));
            return this;
        }

        /// PropertyNamingStrategy ----------------------------------------------------------

        /**
         * 驼峰转小写下划线
         *
         * @return Builder
         */
        public Builder snakeCase() {
            return this.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        }

        /**
         * 首字母大写驼峰
         *
         * @return Builder
         */
        public Builder upperCamelCase() {
            return this.propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        }

        /**
         * 首字母小写驼峰
         *
         * @return Builder
         */
        public Builder lowerCamelCase() {
            return this.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        }

        /**
         * 驼峰转全小写(没有驼峰)
         *
         * @return Builder
         */
        public Builder lowerCase() {
            return this.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);
        }

        /**
         * 驼峰转分隔符, 类似于下划线(下划线变成了分隔符)
         *
         * @return Builder
         */
        public Builder kebabCase() {
            return this.propertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
        }

        /// DeserializationFeature ----------------------------------------------------------

        public Builder disableFailOnUnknownProperties() {
            return this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }

        public Builder disableOnIgnoredProperties() {
            return this.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        }

        /// SerializationFeature ------------------------------------------------------------

        public Builder disableWriteDatesAsTimestamps() {
            return this.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }

        public Builder disableWriteDateTimestampsAsNanoseconds() {
            return this.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
        }

        public Builder disableFailOnEmptyBeans() {
            return this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        }

        /**
         * 注册 LocalDateTime
         *
         * @param pattern 时间格式表达式
         * @return Builder
         */
        public Builder addJavaTimeModule(String pattern) {
            JavaTimeModule    jtm = new JavaTimeModule();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
            jtm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dtf));
            jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dtf));
            return this.addModule(jtm);
        }


        /// -------------------------------------------------------------------------

        public Builder enable(JsonReadFeature... features) {
            for (JsonReadFeature f : features) {
                _mapper.enable(f.mappedFeature());
            }
            return this;
        }

        public Builder disable(JsonReadFeature... features) {
            for (JsonReadFeature f : features) {
                _mapper.disable(f.mappedFeature());
            }
            return this;
        }

        public Builder configure(JsonReadFeature f, boolean state) {
            if (state) {
                _mapper.enable(f.mappedFeature());
            } else {
                _mapper.disable(f.mappedFeature());
            }
            return this;
        }

        public Builder enable(JsonWriteFeature... features) {
            for (JsonWriteFeature f : features) {
                _mapper.enable(f.mappedFeature());
            }
            return this;
        }

        public Builder disable(JsonWriteFeature... features) {
            for (JsonWriteFeature f : features) {
                _mapper.disable(f.mappedFeature());
            }
            return this;
        }

        public Builder configure(JsonWriteFeature f, boolean state) {
            if (state) {
                _mapper.enable(f.mappedFeature());
            } else {
                _mapper.disable(f.mappedFeature());
            }
            return this;
        }

        /// -------------------------------------------------------------------------

        /**
         * build
         *
         * @return JacksonMapper
         */
        public JacksonMapper build() {
            return _mapper;
        }

    }


}
