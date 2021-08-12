import java.util.List;
import java.util.Objects;

public class DataTests {

    private List<DataValues> tests;

    public DataTests(List<DataValues> tests) {
        this.tests = tests;
    }

    public List<DataValues> getTests() {
        return tests;
    }

    public void setTests(List<DataValues> tests) {
        this.tests = tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataTests dataTests = (DataTests) o;
        return Objects.equals(tests, dataTests.tests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tests);
    }
}
