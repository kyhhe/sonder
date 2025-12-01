package cpen221A.sonder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerTest {

    @Test
    public void test_getters() {
        Flower f = new Flower(1);
        f.setPosition(1, 3);
        assertEquals(1, f.getId());
        assertEquals(1, f.getRow());
        assertEquals(3, f.getCol());
    }

    @Test
    public void test_invalidFlowerId() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(0));
        assertThrows(IllegalArgumentException.class, () -> new Flower(16));
    }

    @Test
    public void test_ImagePath() {
        Flower f = new Flower(11);
        assertEquals("/FlowerImages/Flower11.PNG", f.getImagePath());
    }
}
