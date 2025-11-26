package cpen221A.sonder;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class entryTest {

    @BeforeEach
    public void setup() {
        EntryManagement.initializeJSON();
    }

    @Test
    public void test_initialize() {
        EntryManagement.initializeJSON();
        List<UserEntry> entry = EntryManagement.readEntries();
        assertNotNull(entry);
        assertEquals(0, entry.size());
    }

    @Test
    public void test_saveReadEntry() {
        LocalDateTime now = LocalDateTime.now();
        Flower f = new Flower(1);
        UserEntry entry = new UserEntry(now, "/FaceImages/Face1.PNG", "cpen221A", "Sonder", f);
        EntryManagement.saveNewEntry(entry);
        List<UserEntry> entries = EntryManagement.readEntries();
        UserEntry readE = entries.get(0);
        assertEquals(1, entries.size());
        assertEquals("/FaceImages/Face1.PNG", readE.getTask1Answer());
        assertEquals("cpen221A", readE.getTask2Answer());
        assertEquals("Sonder", readE.getTask3Answer());
        assertEquals(now.toLocalDate().toString(), readE.getDate());
        assertEquals(f.getId(), readE.getFlower().getId());
    }

    @Test
    public void test_checkValid() {
        LocalDateTime now = LocalDateTime.now();
        Flower f = new Flower(1);
        UserEntry entry = new UserEntry(now, "/FaceImages/Face1.PNG", "cpen221A", "Sonder", f);
        assertTrue(entry.checkValidEntry());
        UserEntry entry1 = new UserEntry(now, null, null, null, f);
        assertFalse(entry1.checkValidEntry());
    }
}
