/**
 * The HeapUtils class provides methods that allow the user to
 * perform various actions on a heap, such as turning a broken heap
 * into a heap, inserting and removing into the heap, and creating a brand
 * new heap. The methods provided are coded for a min heap, but can be transformed
 * to work for a max heap.
 *
 * @author Keshav Kotamraju
 * @version January 10, 2024
 */
public class HeapUtils {
    /**
     * Heapify guarantees that the tree at a given index is a
     * heap, with each parent node being greater or less than its child, depending
     * on whether it is a max or min heap respectively. If a node invalidates the heap,
     * (does not adhere to the definition above) then the method finds the child to swap
     * the node with in order to maintain the heap. The method uses a helper method in order
     * to swap elements. After calling swap, heapify uses recursion to check that the
     * rest of the tree is a heap. The Big O: log(n), where n is the total number of
     * nodes in the subtree. The swapping method has a big O of 1. Method has a big O of
     * log (n) due to the time complexity of taking a path in the tree.
     *
     * @param heap the heap to be modified
     * @param index the index of the tree
     * @param heapSize the size of the heap
     *
     *
     */
    public static void heapify(Comparable[] heap, int index, int heapSize)
    {
        int leftIndex = index*2;
        if (leftIndex > heapSize)
            return;
        int rightIndex = leftIndex + 1;
        int lowest = index;
        if (leftIndex <= heapSize && heap[leftIndex].compareTo(heap[lowest]) < 0)
        {
            lowest = leftIndex;
        }
        if (rightIndex <= heapSize && heap[rightIndex].compareTo(heap[lowest]) < 0)
        {
            lowest = rightIndex;
        }
        if (lowest != index)
        {
            Comparable temp = heap[index];
            heap[index] = heap[lowest];
            heap[lowest] = temp;
            heapify(heap,lowest,heapSize);
        }
    }
    /**
     * Builds a heap such that the heap contains a complete binary tree
     * and satisfies the heap condition: each child is less/greater
     * than the parent depending on if its a min or max heap. The method
     * achieves this by calling heapify.
     *
     *
     * @param heap the heap to be built
     *
     * @param heapSize the size of the heap
     *
     * Big O: n*log(n)
     * Because the method must take a path in the tree.(log n) and also must iterate
     * n/2 times, the Big O is nlog(n)
     */
    public static void buildHeap(Comparable[] heap, int heapSize)
    {
        for (int i = heapSize/2; i>0; i--)
        {
            heapify(heap,i,heapSize);
        }
    }

    /**
     * The method begins by removing the element at the root of the tree. To preserve
     * the heap, the method also moves the last element of the heap to the root,
     * and then calls heapify in order to fix the heap so that the heap condition is
     * satisfied. Additionally, the heap's size is updated to reflect the new heap.
     *
     * @param heap the heap to be used
     *
     * @param heapSize the size of the heap
     *
     * @return the removed value
     *
     * Big O: log(n)
     * Because the method must take a path in the tree, the Big O is log(n)
     */
    public static Comparable remove(Comparable[] heap, int heapSize)
    {
        Comparable temp = heap[1];
        heap[1] = heap[heapSize];
        heap[heapSize] = temp;
        heapSize = heapSize-1;
        heapify(heap,1,heapSize);
        return temp;
    }

    /**
     * The method places the item being added at the end of the heap. While this temporarily
     * skews the order of the heap, the method calls bubble up so that the item is moved up
     * the heap until it is in the correct position for the min/max heap. After, heapSize
     * is incremented to reflect the added item.
     *
     * @param heap the heap to be used
     *
     * @param item the item to be inserted
     *
     * @param heapSize the size of heap
     *
     * @return the heap
     *
     * Big O: log(n)
     * Because the method must take a path in the tree, the Big O is log(n)
     */
    public static Comparable[] insert(Comparable[] heap, Comparable item, int heapSize)
    {
        if (heapSize + 1 >= heap.length)
        {
            Comparable[] newHeap;
            newHeap = new Comparable[heap.length+1];
            for (int i = 1; i <= heapSize; i++)
            {
                newHeap[i] = heap[i];
            }
        }
        heapSize++;
        heap[heapSize] = item;
        sinkDown(heap,heapSize);
        return heap;
    }

    /**
     * Sink Down method, Sinks down a child node. Helper method for
     * insert
     *
     * @param arr the array to be used
     *
     * @param index the index of the element to be sunk
     *
     * Big O: log(n)
     * Because the method must take a path in the tree, the Big O is log(n)
     */
    public static void sinkDown(Comparable[] arr, int index)
    {
        if (index / 2 == 0)
            return;
        Comparable previous = arr[index/2];
        Comparable current = arr[index];
        int comparison = current.compareTo(previous);
        if (comparison < 0)
        {
            Comparable temp = arr[index/2];
            arr[index/2] = current;
            arr[index] = temp;
            sinkDown(arr,index/2);
        }
    }

    /**
     * Sorts the heap, by building it using an array, and then calling remove
     * on the last element
     *
     * @param arr the array to be used
     *
     * @param heapSize the size of the heap
     *
     * Big O: nlog(n)
     * Because the method must take a path in the tree(log n) and also must iterate
     * n times, the Big O is nlog(n)
     */
    public static void heapSort(Comparable[] arr, int heapSize)
    {
        buildHeap(arr,heapSize);
        for (int i = heapSize; i>0; i--)
        {
            remove(arr,heapSize);
            heapSize--;
        }
    }

}
