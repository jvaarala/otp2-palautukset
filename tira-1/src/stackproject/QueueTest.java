package stackproject;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private static Queue QUEUE;
    private static String DATA1 = "data1";
    private static String DATA2 = "data2";
    private static String DATA3 = "data3";


    @BeforeAll
    static void init(){
        System.out.println("\nStarting...");
        assertNull(QUEUE);
        QUEUE = new Queue();
        assertEquals(0, QUEUE.getSize(), "getSize() not 0 with fresh queue");
    }

    @Test
    void test() {
        assertEquals(DATA1, new ListItem(DATA1).getData(), "ListItem.getData() has incorrect return values");
        QUEUE.push(DATA1);
        assertEquals(1, QUEUE.getSize(), "getSize() failed after first push()");
        assertTrue(QUEUE.pop() instanceof ListItem, "pop() doesn't return ListItem");
        QUEUE.push(DATA1);
        assertEquals(DATA1, QUEUE.pop().getData(), "first try of pop() failed");
        assertEquals(0, QUEUE.getSize(), "getSize() failed after first pop()");

        System.out.println("Testing with more items..");
        assertEquals(0, QUEUE.getSize());
        QUEUE.push(DATA1);
        QUEUE.push(DATA2);
        QUEUE.push(DATA3);
        assertEquals(3, QUEUE.getSize());
        QUEUE.pop();
        QUEUE.pop();
        QUEUE.pop();
        assertNull(QUEUE.pop());
        assertEquals(0, QUEUE.getSize());
        assertNull(QUEUE.pop());

        QUEUE.push(DATA1);
        assertEquals(DATA1, QUEUE.pop().getData());
        QUEUE.push(DATA2);
        QUEUE.push(DATA3);
        assertEquals(DATA2, QUEUE.pop().getData());
        assertEquals(DATA3, QUEUE.pop().getData());
        assertNull(QUEUE.pop());
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Done.");
    }

}