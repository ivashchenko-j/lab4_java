

import org.example.Clothes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JunitTest {

    @Test
    void shouldThrowExceptionWhenNegativePriceInSetter() {
        Clothes item = new Clothes("T-Shirt", "M", "Red", 299.99);
        assertThrows(IllegalArgumentException.class, () -> {
            item.setPrice(-50.0);
        });
    }

    @Test
    void shouldThrowExceptionWhenEmptyNameInSetter() {
        Clothes item = new Clothes("T-Shirt", "M", "Red", 299.99);
        assertThrows(IllegalArgumentException.class, () -> {
            item.setName("");
        });
    }

    @Test
    void shouldThrowExceptionWhenNullNameInSetter() {
        Clothes item = new Clothes("T-Shirt", "M", "Red", 299.99);
        assertThrows(IllegalArgumentException.class, () -> {
            item.setName(null);
        });
    }

    @Test
    void shouldThrowExceptionWhenEmptySizeInSetter() {
        Clothes item = new Clothes("T-Shirt", "M", "Red", 299.99);
        assertThrows(IllegalArgumentException.class, () -> {
            item.setSize("   ");
        });
    }

    @Test
    void shouldThrowExceptionWhenNullColorInSetter() {
        Clothes item = new Clothes("T-Shirt", "M", "Red", 299.99);
        assertThrows(IllegalArgumentException.class, () -> {
            item.setColor(null);
        });
    }

    @Test
    void shouldThrowExceptionWhenEmptyConstructorName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("", "L", "Blue", 500.0);
        });
    }

    @Test
    void shouldThrowExceptionWhenNegativeConstructorPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("Jacket", "XL", "Black", -10.0);
        });
    }

    @Test
    void shouldThrowExceptionWhenNullConstructorSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("Jeans", null, "Blue", 800.0);
        });
    }

    @Test
    void shouldThrowExceptionWhenNullConstructorColor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("Coat", "S", null, 1200.0);
        });
    }

    @Test
    void shouldPassWhenValidDataProvided() {
        Clothes item = new Clothes("Shirt", "L", "White", 450.0);
        assertEquals("Shirt", item.getName());
        assertEquals("L", item.getSize());
        assertEquals("White", item.getColor());
        assertEquals(450.0, item.getPrice());
    }
}