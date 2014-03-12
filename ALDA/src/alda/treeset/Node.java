package alda.treeset;

class Node<E extends Comparable<E>> {
	E data;
	Node<E> left, right;
	Node<E> next, prev;

	Node(E data){
		this(data, null, null);
	}
	Node(E data, Node<E> left, Node<E> right){
		this(data, left, right, null, null);
	}
	Node(E data, Node<E> left, Node<E> right, Node<E> next, Node<E> prev){
		this.data = data;
		this.left = left;
		this.right = right;
		this.next = next;
		this.prev = prev;
	}

	public boolean add(E data){
		if (data == null)
			throw new IllegalArgumentException("Can't add null :<");

		return add(data, this);
	}

	private boolean add(E data, Node<E> n){
		int result = data.compareTo(n.data);

		// Om det nya datat är mindre än datat för denna nod
		if (result < 0){
			if (n.left == null){
				Node<E> newNode = new Node<E>(data);
				newNode.left = null;
				newNode.right = null;
				newNode.next = null;
				newNode.prev = null;
				n.left = newNode;
				return true;
			}
			else
				return add(data, n.left);
		}

		// Om det nya datat är större än datat för denna nod
		else if (result > 0){
			if (n.right == null){
				Node<E> newNode = new Node<E>(data);
				n.right = newNode;
				return true;
			}
			else
				return add(data, n.right);
		}

		// Om result är 0 så har data samma värde som nuvarande noden. Gör ingenting.
		else {
			return false;
		}
	}
	
	public String toString(){
		return data.toString();
	}
}