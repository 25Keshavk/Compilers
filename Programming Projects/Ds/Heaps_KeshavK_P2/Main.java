/**
 * The Main class creates a heap from an array with 11 random
 * integers from 1 to 100, and provides methods to test each
 * HeapUtils method. The class allows for the testing of
 * BuildHeap, insert, remove, and HeapSort.
 *
 * @author Keshav Kotamraju
 * @version January 9 2024
 */
public class Main {

    /**
     * Creates an array with 11 random integers between
     * 1 and 100, and then displays a heap from the
     * array. Additionally, provides the option
     * to test each HeapUtils method through changing
     * a boolean provided in the code.
     *
     * @param args information from the command line
     */
    public static void main(String[] args) {
        Integer[] heap = new Integer[13];
        for (int i = 1; i < 12; i++) {
            int rand = (int) ((Math.random()* 100)+1);
            heap[i] = rand;
        }
        HeapDisplay dis = new HeapDisplay();
        int heapSize = 11;
        dis.displayHeap(heap, heapSize);

        boolean testbuild = true;
        boolean testinsert = true;
        boolean testremove = true;
        boolean testsort = true;

        if (testbuild) {
            testBuildHeap(heap, heapSize);
        }

        if (testinsert) {
            testInsert(heap, 100, heapSize);
        }

        if (testremove) {
            testRemove(heap, heapSize);
        }

        if (testsort) {
            testHeapSort(heap, heapSize);
        }
    }

    /**
     * Tests Heapify and Build Heap
     *
     * @param heap
     * @param heapSize
     */
    private static void testBuildHeap(Comparable[] heap, int heapSize) {
        System.out.println("Testing buildHeap ");
        System.out.println("Unmodified Array: ");
        String array = java.util.Arrays.toString(heap);
        System.out.println(array);
        HeapUtils.buildHeap(heap, heapSize);
        HeapDisplay display = new HeapDisplay("Heapify");
        display.displayHeap(heap, heapSize);
        System.out.println("Heapified Array: ");
        String heapify = java.util.Arrays.toString(heap);
        System.out.println(heapify);
    }

    /**
     * Tests Insert
     *
     * @param heap
     * @param item
     * @param heapSize
     */
    private static void testInsert(Comparable[] heap, int item, int heapSize) {
        System.out.println("Testing insert ");
        HeapUtils.insert(heap, item, heapSize);
        HeapDisplay display = new HeapDisplay("Insert");
        heapSize++;
        display.displayHeap(heap,heapSize);
    }

    /**
     * Tests Remove
     *
     * @param heap
     * @param heapSize
     */
    private static void testRemove(Comparable[] heap, int heapSize) {
        System.out.println("Testing remove ");
        HeapUtils.buildHeap(heap, heapSize);
        HeapUtils.remove(heap, heapSize);
        HeapDisplay display = new HeapDisplay("Remove");
        heapSize--;
        display.displayHeap(heap,heapSize);
    }

    /**
     * Tests HeapSort
     *
     * @param heap
     * @param heapSize
     */
    private static void testHeapSort(Comparable[] heap, int heapSize) {
        System.out.println("Testing heapSort ");
        System.out.println("Unmodified Array: ");
        String array = java.util.Arrays.toString(heap);
        System.out.println(array);
        HeapUtils.heapSort(heap, heapSize);
        System.out.println("Sorted Array: ");
        String sorted = java.util.Arrays.toString(heap);
        System.out.println(sorted);
    }
}


