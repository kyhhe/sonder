package cpen221A.sonder;

import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GardenLogicTest {

    @BeforeEach
    public void setUp() {
        GardenLogic.clearGarden();
    }

    @Test
    public void test_addFlower(){
        Flower f = new Flower(1);
        assertTrue(GardenLogic.isEmpty(0,0));
        assertTrue(GardenLogic.addFlower(f,0,0));
        assertFalse(GardenLogic.isEmpty(0,0));
        Flower f2 = new Flower(1);
        assertFalse(GardenLogic.addFlower(f2,0,0));
        assertThrows(IllegalArgumentException.class, () -> GardenLogic.addFlower(f,-1, 0));
    }

    @Test
    public void test_flowerInGar(){
        Flower f = new Flower(1);
        assertFalse(GardenLogic.flowerInGarden(f));
        GardenLogic.addFlower(f,0,0);
        assertTrue(GardenLogic.flowerInGarden(f));
    }

    @Test
    public void test_isFull_fortnight(){
        GardenLogic.set14Flowers();
        assertTrue(GardenLogic.isFortnight());
        assertFalse(GardenLogic.isFull());

        GardenLogic.setAllFlowers();
        assertTrue(GardenLogic.isFull());
    }

    @Test
    public void test_saveLoadGarden(){
        Flower f = new Flower(1);
        GardenLogic.addFlower(f,0,0);
        GardenLogic.saveGarden();
        GardenLogic.clearGarden();
        assertTrue(GardenLogic.isEmpty(0,0));
        GardenLogic.loadGarden();
        GardenLogic.addFlower(f,0,0);
        GardenLogic.saveGarden();
        List<List<Flower>> g = GardenLogic.getGarden();
        assertNotNull(g.get(0).get(0));
        assertEquals(f.getId(), g.get(0).get(0).getId());
        assertThrows(IllegalArgumentException.class, () -> GardenLogic.isEmpty(-1,0));
    }

    @Test
    public void test_clearGarden(){
        GardenLogic.addFlower(new Flower(1),0,0);
        GardenLogic.addFlower(new Flower(2),0,1);
        GardenLogic.clearGarden();
        for(List<Flower> r : GardenLogic.getGarden()){
            for(Flower f : r){
                assertNull(f);
            }
        }
    }

    @Test
    public void test_setAllFlowers(){
        GardenLogic.setAllFlowers();
        List<List<Flower>> g = GardenLogic.getGarden();
        int count = 0;
        for(List<Flower> r : g){
            for(Flower f : r){
                if(f != null) count ++;
            }
        }
        assertEquals(15,count);
    }

    @Test
    public void test_flowerInGarden() {
        Flower f1 = new Flower(3);
        GardenLogic.addFlower(f1,0,0);

        Flower f2 = new Flower(3);

        assertTrue(GardenLogic.flowerInGarden(f2));
    }
}
