import java.time.Year;

public class Person {
    private String ID = "";
    private String firstName = "";
    private String lastName = "";
    private String title = "";
    private int YOB = 0;

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Year.now().getValue();
        return Integer.toString(currentYear - YOB);
    }

    public String getAge(int year) {
        return Integer.toString(year - YOB);
    }

    public String toCSVDataRecord() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }
}
