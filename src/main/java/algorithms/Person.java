package algorithms;

public class Person {
    private int id;
    private String address;

    public Person(int id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
