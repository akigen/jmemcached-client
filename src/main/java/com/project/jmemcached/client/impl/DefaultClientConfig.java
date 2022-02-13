package com.project.jmemcached.client.impl;

import com.project.jmemcached.client.ClientConfig;
import com.project.jmemcached.protocol.ObjectSerializer;
import com.project.jmemcached.protocol.RequestConverter;
import com.project.jmemcached.protocol.ResponseConverter;
import com.project.jmemcached.protocol.impl.DefaultObjectSerializer;
import com.project.jmemcached.protocol.impl.DefaultRequestConverter;
import com.project.jmemcached.protocol.impl.DefaultResponseConverter;

class DefaultClientConfig implements ClientConfig {
    private final String host;
    private final int port;
    private final RequestConverter requestConverter;
    private final ResponseConverter responseConverter;
    private final ObjectSerializer objectSerializer;

    DefaultClientConfig(String host, int port) {
        this.host = host;
        this.port = port;
        this.requestConverter = new DefaultRequestConverter();
        this.responseConverter = new DefaultResponseConverter();
        this.objectSerializer = new DefaultObjectSerializer();
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public RequestConverter getRequestConverter() {
        return requestConverter;
    }

    @Override
    public ResponseConverter getResponseConverter() {
        return responseConverter;
    }

    @Override
    public ObjectSerializer getObjectSerializer() {
        return objectSerializer;
    }
}
