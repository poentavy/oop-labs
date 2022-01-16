package lab11.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMultiMapValue {
    private MultiMapValue<String, String> map;

    @BeforeEach
    public void setup() {
        map = new MultiMapValue<>();
    }

    @AfterEach
    public void clean() {
        map = null;
    }

    @Test
    public void testAddElementWithOneValue() {
        map.add("key", "value");
        Assertions.assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertEquals(1, map.getValues("key").size());
    }

    @Test
    public void testAddElementWithMoreValues() {
        map.add("key", "value1");
        map.add("key", "value2");
        Assertions.assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertEquals(2, map.getValues("key").size());
    }

    @Test
    public void testAddTwoElements() {
        map.add("key1", "value1");
        map.add("key1", "value2");
        Assertions.assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        map.add("key2", "value3");
        assertEquals(2, map.size());
    }

    @Test
    public void testGetFirst() {
        map.add("key", "value1");
        map.add("key", "value2");
        Assertions.assertNotEquals("value2", map.getFirst("key"));
        assertEquals("value1", map.getFirst("key"));
    }

    @Test
    public void testContainsKey() {
        Assertions.assertFalse(map.containsKey("key"));
        map.add("not_key", "value");
        Assertions.assertFalse(map.containsKey("key"));
        map.add("key", "value");
        Assertions.assertTrue(map.containsKey("key"));
    }

    @Test
    public void testSize() {
        assertEquals(0, map.size());
        map.add("key", "value1");
        map.add("key", "value2");
        assertEquals(false, map.isEmpty());
        assertEquals(1, map.size());
        map.add("key2", "value3");
        assertEquals(2, map.size());
    }

    @Test
    public void testRemoveKey() {
        assertEquals(null, map.remove("key"));
        map.add("key", "value1");
        map.add("key", "value2");
        ArrayList<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        assertEquals(values, map.remove("key"));
        assertEquals(0, map.size());
        map.add("key", "value1");
        map.add("key", "value2");
        map.add("safe_key", "value");
        values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        assertEquals(Collections.unmodifiableList(values), map.remove("key"));
        Assertions.assertNotEquals(0, map.size());
    }

    @Test
    public void testAddAllWithList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        Assertions.assertTrue(map.isEmpty());
        map.addAll("key", values);
        Assertions.assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertEquals(2, map.getValues("key").size());
        map.remove("key");
        values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        map.add("key", "value0");
        map.addAll("key", values);
        assertEquals(1, map.size());
        assertEquals(3, map.getValues("key").size());

    }

    @Test
    public void testAddAllWithMultiMapValue() {
        var newMap = new MultiMapValue<String, String>();
        newMap.add("key1", "value1");
        newMap.add("key1", "value2");
        newMap.add("key2", "value1");
        Assertions.assertTrue(map.isEmpty());
        map.addAll(newMap);
        Assertions.assertFalse(map.isEmpty());
        assertEquals(2, map.size());
        assertEquals(2, map.getValues("key1").size());
        assertEquals(1, map.getValues("key2").size());
    }
}