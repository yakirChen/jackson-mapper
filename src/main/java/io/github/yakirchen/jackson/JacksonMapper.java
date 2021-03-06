package io.github.yakirchen.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

/**
 * JacksonMapper Unchecked Exception
 *
 * @author yakir <a href="https://yakirchen.github.io">yakirchen.github.io</a> on 2018/07/12 17:57.
 */
public class JacksonMapper extends ObjectMapper {

    private static final long serialVersionUID = 5403455382358517149L;

    private static final Logger log = LogManager.getLogger(JacksonMapper.class);

    private static final String ERROR_MSG = "JacksonMapper发生异常";

    public JacksonMapper() {
    }

    @Override
    public <T> T convertValue(Object fromValue, Class<T> toValueType) {

        try {
            return super.convertValue(fromValue, toValueType);
        } catch (IllegalArgumentException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        try {
            return super.convertValue(fromValue, toValueTypeRef);
        } catch (IllegalArgumentException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T convertValue(Object fromValue, JavaType toValueType) {
        try {
            return super.convertValue(fromValue, toValueType);
        } catch (IllegalArgumentException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public byte[] writeValueAsBytes(Object value) {
        try {
            return super.writeValueAsBytes(value);
        } catch (JsonProcessingException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public void writeValue(final JsonGenerator g, final Object value) {
        try {
            super.writeValue(g, value);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public String writeValueAsString(Object value) {
        try {
            return super.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public void writeValue(Writer w, Object value) {
        try {
            super.writeValue(w, value);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeValue(DataOutput out, Object value) {
        try {
            super.writeValue(out, value);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeValue(File resultFile, Object value) {
        try {
            super.writeValue(resultFile, value);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeValue(OutputStream out, Object value) {
        try {
            super.writeValue(out, value);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeTree(JsonGenerator jgen, JsonNode rootNode) {
        try {
            super.writeTree(jgen, rootNode);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeTree(JsonGenerator jgen, TreeNode rootNode) {
        try {
            super.writeTree(jgen, rootNode);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public JsonNode readTree(Reader r) {
        try {
            return super.readTree(r);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(URL source) {
        try {
            return super.readTree(source);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(InputStream in) {
        try {
            return super.readTree(in);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(File file) {
        try {
            return super.readTree(file);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(byte[] content) {
        try {
            return super.readTree(content);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(String content) {
        try {
            return super.readTree(content);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p, Class<T> valueType) {
        try {
            return super.readValues(p, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(JsonParser p, Class<T> valueType) {
        try {
            return super.readValue(p, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(JsonParser p, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(p, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(JsonParser p, JavaType valueType) {
        try {
            return super.readValue(p, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(File src, Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(File src, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(File src, JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(URL src, Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(URL src, JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(URL src, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(String content, Class<T> valueType) {
        try {
            return super.readValue(content, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(content, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(String content, JavaType valueType) {
        try {
            return super.readValue(content, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(Reader src, Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(Reader src, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(Reader src, JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(InputStream src, Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(InputStream src, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(InputStream src, JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src, Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src, int offset, int len, Class<T> valueType) {
        try {
            return super.readValue(src, offset, len, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src, int offset, int len, TypeReference<T> valueTypeRef) {
        try {
            return super.readValue(src, offset, len, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src, JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src, int offset, int len, JavaType valueType) {
        try {
            return super.readValue(src, offset, len, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(DataInput src, Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p, JavaType valueType) {
        try {
            return super.readValues(p, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p, ResolvedType valueType) {
        try {
            return super.readValues(p, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p, TypeReference<T> valueTypeRef) {
        try {
            return super.readValues(p, valueTypeRef);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(DataInput src, JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T extends TreeNode> T readTree(JsonParser p) {
        try {
            return super.readTree(p);
        } catch (IOException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T treeToValue(TreeNode n, Class<T> valueType) {
        try {
            return super.treeToValue(n, valueType);
        } catch (JsonProcessingException e) {
            log.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    public CollectionType constructCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return super.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    public MapType constructconstructMapTypeCollectionType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        return super.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
    }

    public <T> String defaultPrettyPrinter(T obj) {

        SerializationConfig config       = getSerializationConfig();
        ObjectWriter        objectWriter = _newWriter(config, null, config.getDefaultPrettyPrinter());
        try {
            return objectWriter.writeValueAsString(obj);
        } catch (JsonProcessingException exc) {
            return null;
        }
    }

    public <T> String withPrettyPrinter(T t) {
        try {
            return super.writerWithDefaultPrettyPrinter().writeValueAsString(t);
        } catch (JsonProcessingException exc) {
            return null;
        }
    }
}
