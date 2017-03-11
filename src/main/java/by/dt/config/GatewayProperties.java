package by.dt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@ConfigurationProperties(prefix = "gateway")
public class GatewayProperties {

    private Queue queue = new Queue();

    public GatewayProperties() {
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GatewayProperties that = (GatewayProperties) o;
        return Objects.equals(queue, that.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queue);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GatewayProperties{");
        sb.append("queue=").append(queue);
        sb.append('}');
        return sb.toString();
    }

    public static class Queue {

        private List<String> names = new ArrayList<>();

        public Queue() {
        }

        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Queue queue = (Queue) o;
            return Objects.equals(names, queue.names);
        }

        @Override
        public int hashCode() {
            return Objects.hash(names);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Queue{");
            sb.append("names=").append(names);
            sb.append('}');
            return sb.toString();
        }
    }
}
