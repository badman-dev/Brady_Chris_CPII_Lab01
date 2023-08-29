import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2;

    @BeforeEach
    void setUp() {
        p1 = new Product("000001", "Hammer", "Used for hammering nails into place", 24.99);
        p2 = new Product("000002", "Screwdriver", "Used for screwing screws into a hole", 19.99);
    }

    @Test
    void setID() {
        p1.setID("00000A");
        assertEquals("00000A", p1.getID());
        p2.setID("00000B");
        assertEquals("00000B", p2.getID());
    }

    @Test
    void setName() {
        p1.setName("Thingus");
        assertEquals("Thingus", p1.getName());
        p2.setName("Wahh!!!");
        assertEquals("Wahh!!!", p2.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Does stuff");
        assertEquals("Does stuff", p1.getDescription());
        p2.setDescription("Does nothing");
        assertEquals("Does nothing", p2.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(9.99);
        assertEquals(9.99, p1.getCost());
        p2.setCost(23232.23);
        assertEquals(23232.23, p2.getCost());
    }

    @Test
    void toCSVDataRecord() {
        String csv1 = p1.toCSVDataRecord();
        assertEquals(csv1, p1.getID() + ", " + p1.getName() + ", " + p1.getDescription() + ", " + p1.getCost());
        String csv2 = p2.toCSVDataRecord();
        assertEquals(csv2, p2.getID() + ", " + p2.getName() + ", " + p2.getDescription() + ", " + p2.getCost());
    }
}