package com.project.jmemcached.client.impl;

import com.project.jmemcached.protocol.impl.DefaultObjectSerializer;
import com.project.jmemcached.protocol.impl.DefaultRequestConverter;
import com.project.jmemcached.protocol.impl.DefaultResponseConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultClientConfigTest {
    private final DefaultClientConfig defaultClientConfig = new DefaultClientConfig("localhost", 9010);

    @Test
    void testGetHost() {
        assertEquals("localhost", defaultClientConfig.getHost());
    }

    @Test
    void testGetPort() {
        assertEquals(9010, defaultClientConfig.getPort());
    }

    @Test
    void testGetRequestConverter() {
        assertEquals(DefaultRequestConverter.class, defaultClientConfig.getRequestConverter().getClass());
    }

    @Test
    void testGetResponseConverter() {
        assertEquals(DefaultResponseConverter.class, defaultClientConfig.getResponseConverter().getClass());
    }

    @Test
    void testGetObjectSerializer() {
        assertEquals(DefaultObjectSerializer.class, defaultClientConfig.getObjectSerializer().getClass());
    }
}