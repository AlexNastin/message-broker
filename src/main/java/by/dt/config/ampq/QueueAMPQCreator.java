package by.dt.config.ampq;

import org.springframework.amqp.core.Queue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class QueueAMPQCreator {

    private List<String> names;

    private Map<String, Queue> queues = new HashMap<>();

    public QueueAMPQCreator(List<String> names) {
        this.names = names;
    }

    public Map<String, Queue> createQueues() {
        for (int i = 0; i < names.size(); i++) {
            queues.put(names.get(i), new Queue(names.get(i)));
        }
        return queues;
    }

    public Map<String, Queue> getQueues() {
        return queues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueAMPQCreator that = (QueueAMPQCreator) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueueAMPQCreator{");
        sb.append("names=").append(names);
        sb.append('}');
        return sb.toString();
    }
}
