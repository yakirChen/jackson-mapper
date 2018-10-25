package com.yakirchen.jackson;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

/**
 * JacksonMapper Unchecked Exception
 *
 * @author yakir <a href="yakirchen.com">yakirchen.com</a> on 07/12/2018 17:57.
 */
public class JacksonMapper
        extends ObjectMapper {

    private static final long   serialVersionUID = 5403455382358517149L;
    private static final Logger logger           = LoggerFactory.getLogger(JacksonMapper.class);

    private final String ERROR_MSG = "JacksonMapper发生异常";

    public JacksonMapper() {
    }

    @Override
    public byte[] writeValueAsBytes(Object value) {
        try {
            return super.writeValueAsBytes(value);
        } catch (JsonProcessingException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public void writeValue(final JsonGenerator g,
                           final Object value) {
        try {
            super.writeValue(g, value);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public String writeValueAsString(Object value) {
        try {
            return super.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public void writeValue(Writer w,
                           Object value) {
        try {
            super.writeValue(w, value);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeValue(DataOutput out,
                           Object value) {
        try {
            super.writeValue(out, value);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeTree(JsonGenerator jgen,
                          JsonNode rootNode) {
        try {
            super.writeTree(jgen, rootNode);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public void writeTree(JsonGenerator jgen,
                          TreeNode rootNode) {
        try {
            super.writeTree(jgen, rootNode);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
        }
    }

    @Override
    public JsonNode readTree(Reader r) {
        try {
            return super.readTree(r);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(URL source) {
        try {
            return super.readTree(source);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(InputStream in) {
        try {
            return super.readTree(in);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(File file) {
        try {
            return super.readTree(file);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(byte[] content) {
        try {
            return super.readTree(content);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public JsonNode readTree(String content) {
        try {
            return super.readTree(content);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p,
                                             Class<T> valueType) {
        try {
            return super.readValues(p, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(JsonParser p,
                           Class<T> valueType) {
        try {
            return super.readValue(p, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(JsonParser p,
                           TypeReference<?> valueTypeRef) {
        try {
            return super.readValue(p, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(JsonParser p,
                           JavaType valueType) {
        try {
            return super.readValue(p, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(File src,
                           Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(File src,
                           TypeReference valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(File src,
                           JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(URL src,
                           Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(URL src,
                           JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(URL src,
                           TypeReference valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(String content,
                           Class<T> valueType) {
        try {
            return super.readValue(content, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(String content,
                           TypeReference valueTypeRef) {
        try {
            return super.readValue(content, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(String content,
                           JavaType valueType) {
        try {
            return super.readValue(content, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(Reader src,
                           Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(Reader src,
                           TypeReference valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(Reader src,
                           JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(InputStream src,
                           Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(InputStream src,
                           TypeReference valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(InputStream src,
                           JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src,
                           Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src,
                           int offset,
                           int len,
                           Class<T> valueType) {
        try {
            return super.readValue(src, offset, len, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src,
                           TypeReference valueTypeRef) {
        try {
            return super.readValue(src, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src,
                           int offset,
                           int len,
                           TypeReference valueTypeRef) {
        try {
            return super.readValue(src, offset, len, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src,
                           JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(byte[] src,
                           int offset,
                           int len,
                           JavaType valueType) {
        try {
            return super.readValue(src, offset, len, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(DataInput src,
                           Class<T> valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p,
                                             JavaType valueType) {
        try {
            return super.readValues(p, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p,
                                             ResolvedType valueType) {
        try {
            return super.readValues(p, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p,
                                             TypeReference<?> valueTypeRef) {
        try {
            return super.readValues(p, valueTypeRef);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T> T readValue(DataInput src,
                           JavaType valueType) {
        try {
            return super.readValue(src, valueType);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }

    @Override
    public <T extends TreeNode> T readTree(JsonParser p) {
        try {
            return super.readTree(p);
        } catch (IOException e) {
            logger.error("{}", ERROR_MSG, e);
            return null;
        }
    }
}
