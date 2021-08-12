import java.util.Objects;

public class DataJson {
    private long id;
    private String value;

    public DataJson(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataJson dataJson = (DataJson) o;
        return id == dataJson.id && Objects.equals(value, dataJson.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
