package by.dt.entity;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class HttpMessage {

    private HttpStatus status;
    private String url;
    private String message;

    public HttpMessage() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpMessage that = (HttpMessage) o;
        return status == that.status &&
                Objects.equals(url, that.url) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, url, message);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HttpMessage{");
        sb.append("status=").append(status);
        sb.append(", url='").append(url).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
