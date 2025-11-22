/**
 * provides a Binary Seaqrch Tree and allows for operations like adding and removing
 * to be done on the BST
 * @author Keshav Kotamraju
 * @version 30 November 2023
 */
public class BSTUtilities extends TreeUtil
{
	/**
	 * precondition:  t is a binary search tree in ascending order
	 * postcondition: returns true if t contains the value x;
	 * otherwise, returns false
	 *
	 * @param t the BST
	 *
	 * @param x the value to be searched for
	 *
	 * @param display the TreeDisplay
	 *
	 * @return true if the tree contains value x;
	 *         otherwise, false
	 */

	public static boolean contain(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (t == null)
			return false;
		if (x.compareTo(t.getValue()) == 0)
			return true;
		if (x.compareTo(t.getValue())>0)
		{
			return contain(t.getRight(),x,display);
		}
		return contain(t.getLeft(),x,display);
	}

	/**
	 *   precondition:  t is a binary search tree in ascending order
	 *   postcondition: if t is empty, returns a new tree containing x;
	 *               otherwise, returns t, with x having been inserted
	 *               at the appropriate position to maintain the binary
	 *               search tree property; x is ignored if it is a
	 *               duplicate of an element already in t; only one new
	 *               TreeNode is created in the course of the traversal
	 * @param t the BST
	 *
	 * @param x the value being inserted
	 *
	 * @param display the TreeDisplay
	 *
	 * @return if t is empty, returns a new BST containing x;
	 *               otherwise, returns t, with x inserted
	 *               at the ordered position
	 */
	public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
	{
		display.visit(t);
		if (t == null)
		{
			return new TreeNode(x);
		}
		if (x.compareTo(t.getValue()) < 0)
		{
			t.setLeft(insert(t.getLeft(),x,display));
		}
		else if (x.compareTo(t.getValue()) > 0)
		{
			t.setRight(insert(t.getRight(),x,display));
		}
		if (x.equals(t.getValue()))
		{
			return t;
		}
		return t;
	}

	/**
	 //precondition:  t is a binary search tree in ascending order
	 //postcondition: returns a pointer to a binary search tree,
	 //               in which the value at node t has been deleted
	 //               (and no new TreeNodes have been created)
	 * @param t the BST
	 *
	 * @display the TreeDisplay
	 *
	 * @return a pointer to the BST
	 */
	private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
	{
		if (t.getLeft() == null)
			return t.getRight();
		else if (t.getRight() == null)
			return t.getLeft();
		else
		{
			Object previous = TreeUtil.rightmost(t.getLeft());
			t.setValue(previous);
			TreeNode rest = delete(t.getLeft(),(Comparable)previous,display);
			t.setLeft(rest);
		}
		return t;
	}
	/**
	 //precondition:  t is a binary search tree in ascending order
	 //postcondition: returns a pointer to a binary search tree,
	 //               in which the value x has been deleted (if present)
	 //               (and no new TreeNodes have been created)
	 * @param t the BST
	 *
	 * @param x the value being deleted
	 *
	 * @param display the TreeDisplay
	 *
	 * @return a pointer to the BST
	 */
	public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (t == null)
			return null;
		int compare = x.compareTo(t.getValue());
		if (compare < 0)
		{
			TreeNode rest = delete(t.getLeft(),x,display);
			t.setLeft(rest);
			return t;
		}
		if (compare > 0)
		{
			TreeNode rest = delete(t.getRight(),x,display);
			t.setRight(rest);
			return t;
		}
		else
		{
			return deleteNode(t,display);
		}
	}
}