package com.project.jmemcached.client;

import com.project.jmemcached.protocol.ObjectSerializer;
import com.project.jmemcached.protocol.RequestConverter;
import com.project.jmemcached.protocol.ResponseConverter;

public interface ClientConfig {

    String getHost();

    int getPort();

    RequestConverter getRequestConverter();

    ResponseConverter getResponseConverter();

    ObjectSerializer getObjectSerializer();

}
