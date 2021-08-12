import java.util.List;
import java.util.Objects;

public class DataValues {
    private long id;
    private String title;
    private String value;

    private List<DataValues> values;

    public DataValues(long id, String title, String value, List<DataValues> values) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = values;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DataValues> getValues() {
        return values;
    }

    public void setValues(List<DataValues> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataValues that = (DataValues) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(value, that.value) && Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, value, values);
    }
}
