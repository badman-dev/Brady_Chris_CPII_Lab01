import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2;

    @BeforeEach
    void setUp() {
        p1 = new Person("000001", "Tom", "Wulf", "Prof.",1958);
        p2 = new Person("000002", "John", "Dinkle", "Dr.",1985);
    }

    @Test
    void setID() {
        p1.setID("00000A");
        assertEquals("00000A", p1.getID());
        p2.setID("00000B");
        assertEquals("00000B", p2.getID());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Robert");
        assertEquals("Robert", p1.getFirstName());
        p2.setFirstName("Zowa");
        assertEquals("Zowa", p2.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Bobkins");
        assertEquals("Bobkins", p1.getLastName());
        p2.setLastName("Brady");
        assertEquals("Brady", p2.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Dr.");
        assertEquals("Dr.", p1.getTitle());
        p2.setTitle("Mrs.");
        assertEquals("Mrs.", p2.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(1990);
        assertEquals(1990, p1.getYOB());
        p2.setYOB(1956);
        assertEquals(1956, p2.getYOB());
    }

    @Test
    void fullName() {
        String full1 = p1.fullName();
        assertEquals(full1, p1.getFirstName() + " " + p1.getLastName());
        String full2 = p2.fullName();
        assertEquals(full2, p2.getFirstName() + " " + p2.getLastName());
    }

    @Test
    void formalName() {
        String formal1 = p1.formalName();
        assertEquals(formal1, p1.getTitle() + " " + p1.getFirstName() + " " + p1.getLastName());
        String formal2 = p2.formalName();
        assertEquals(formal2, p2.getTitle() + " " + p2.getFirstName() + " " + p2.getLastName());
    }

    @Test
    void getAge1() {
        int currentYear = Year.now().getValue();
        String age1 = p1.getAge();
        assertEquals(age1, Integer.toString(currentYear - p1.getYOB()));
        String age2 = p2.getAge();
        assertEquals(age2, Integer.toString(currentYear - p2.getYOB()));
    }

    @Test
    void getAge2() {
        int year = 2012;
        String age1 = p1.getAge(year);
        assertEquals(age1, Integer.toString(year - p1.getYOB()));
        String age2 = p2.getAge(year);
        assertEquals(age2, Integer.toString(year - p2.getYOB()));
    }

    @Test
    void toCSVDataRecord() {
        String csv1 = p1.toCSVDataRecord();
        assertEquals(csv1, p1.getID() + ", " + p1.getFirstName() + ", " + p1.getLastName() + ", " + p1.getTitle() + ", " + p1.getYOB());
        String csv2 = p2.toCSVDataRecord();
        assertEquals(csv2, p2.getID() + ", " + p2.getFirstName() + ", " + p2.getLastName() + ", " + p2.getTitle() + ", " + p2.getYOB());
    }
}