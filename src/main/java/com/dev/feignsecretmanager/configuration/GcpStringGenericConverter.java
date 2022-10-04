package com.dev.feignsecretmanager.configuration;

import com.google.protobuf.ByteString;
import java.util.HashSet;
import java.util.Set;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

/**
 * This class is a workaround to load the converter ByteString to String
 * to the CustomBasicAuthConfiguration when feign client bean is created
 */

public class GcpStringGenericConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>(1);
        convertiblePairs.add(new ConvertiblePair(ByteString.class, String.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return ((ByteString)source).toStringUtf8();
    }
}
