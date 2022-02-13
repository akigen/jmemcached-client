package external.project;

import com.project.jmemcached.client.Client;
import com.project.jmemcached.client.impl.JMemcachedClientFactory;

import java.io.Serializable;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ExternalProject {

    public static void main(String[] args) throws Exception {
        try (Client client = JMemcachedClientFactory.buildNewClient("localhost", 9010)) {
            client.put("test", "Hello world");
            System.out.println(Optional.ofNullable(client.get("test")));

            client.remove("test");
            System.out.println(Optional.ofNullable(client.get("test")));

            client.put("test", "Hello world");
            client.put("test", new BusinessObject("TEST"));
            System.out.println(Optional.ofNullable(client.get("test")));

            client.clear();
            System.out.println(Optional.ofNullable(client.get("test")));

            client.put("learning", "JMemcached Project", 2, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Optional.ofNullable(client.get("learning")));
        }
    }

    private static class BusinessObject implements Serializable {
        private String name;

        BusinessObject(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("BusinessObject{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
