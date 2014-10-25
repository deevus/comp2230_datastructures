package datastructures;
import java.util.NoSuchElementException;

public class BSTree<T extends Comparable> extends BinaryTree<T> {
	public BSTree(T rootVal) {
		super(rootVal);
	}

	public void insert(T val) {
		BinaryNode<T> temp = new BinaryNode<T>();
		temp.data = val;
		if (root == null) {
			root = temp;
		}
		else {
			insertRecursive(root, temp);
		}
	}

	private void insertRecursive(BinaryNode<T> root, BinaryNode<T> temp) {
		if (temp.data.compareTo(root.data) <= 0) {
			if (root.left == null) {
				root.left = temp;
			}
			else {
				insertRecursive(root.left, temp);
			}
		}
		else {
			if (root.right == null) {
				root.right = temp;
			}
			else {
				insertRecursive(root.right, temp);
			}
		}
	}

	public void delete(T val) {
		BinaryNode<T> node = find(val, root);

		//doesn't exist
		if (node == null) {
			throw new NoSuchElementException();
		}

		//zero or one child = replace with child
		if (node.left == null || node.right == null) {
			replace(root, node);
			return;
		}

		//find node succ containing a minimum data item in ref's right subtree
		BinaryNode<T> succ = node.right;
		while (succ.left != null)
			succ = succ.left;

		//"move" succ to ref, thus deleting ref
		node.data = succ.data;

		//delete succ
		replace(root, succ);
	}

	private void replace(BinaryNode<T> root, BinaryNode<T> ref) {
		BinaryNode<T> child;
		if (ref.left == null) {
			child = ref.right;
		}
		else child = ref.left;

		if (ref == root) {
			if (child != null) {
				child.parent = null;
			}
			return;
		}

		if (ref.parent.left == ref) //is ref left child?
			ref.parent.left = child;
		else
			ref.parent.right = child;

		if (child != null) 
			child.parent = ref.parent;
	}

	private BinaryNode<T> find(T val, BinaryNode<T> root) {
		if (root.data.compareTo(val) == 0) {
			return root;
		}
		else if (root.data.compareTo(val) <= 0) {
			return find(val, root.right);
		}
		else return find(val, root.left);
	}
}