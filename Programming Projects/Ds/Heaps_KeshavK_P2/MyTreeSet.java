/**
// @author Keshav Kotamraju
// @version 2 December 2023
 */
public class MyTreeSet<E>
{
	private TreeNode root;
	private int size;
	private TreeDisplay display;

	public MyTreeSet()
	{
		root = null;
		size = 0;
		display = new TreeDisplay();
		display.displayTree(root);
		//wait 1 millisecond when visiting a node
		display.setDelay(50);
	}

	public int size()
	{
		return size;
	}
	/**
	 * Determines if the object is present in the TreeSet
	 * @param obj the object being searched for
	 * @return true if obj is found; otherwise false
	 */
	public boolean contains(Object obj)
	{

		display.displayTree(root);
		return BSTUtilities.contain(root, (Comparable) (obj), display);
	}

	/**
	 * Adds obj to the TreeSet if obj is not already in Treeset
	 * @param obj the object to be added
	 * @return true if obj can be added ; otherwise false
	 */
	public boolean add(E obj)
	{
		boolean val = !contains(obj);
		root = BSTUtilities.insert(root, (Comparable) (obj), display);
		if (val)
			size += 1;
		display.displayTree(root);
		return val;

	}

	/**
	 * Removes obj from the TreeSet if obj is in the TreeSet
	 * @param obj the object being removed
	 * @return true if able to remove; otherwise false
	 */
	public boolean remove(Object obj)
	{
		boolean val = contains(obj);

		if (val)
		{
			root = BSTUtilities.delete(root, (Comparable) (obj), display);
			display.displayTree(root);
			size -=1;
		}


		return val;
	}

	public String toString()
	{
		return toString(root);
	}

	private String toString(TreeNode t)
	{
		if (t == null)
			return " ";
		return toString(t.getLeft()) + t.getValue() + toString(t.getRight());
	}
}