package alda.treeset;

public class TreeSet<T extends Comparable<T>>  {
	private Node<T> root, head, tail;
	private int size;
	
	public TreeSet(){
		root = null;
		tail = new Node<T>(null);
		head = new Node<T>(null);
		head.next = tail;
		tail.prev = head;
	}
	
	public boolean add(T data){
		if (root == null){
			root = new Node<T>(data);
			root.next = tail;
			root.prev = head;
			head.next = root;
			tail.prev = root;
			size++;
			return true;
		} else {
			return root.add(data);
		}
	}
	
	public String toString(){
		if (root != null){
		String s = "[";
		Node<T> current = findMin();
		while (current != tail){
			System.out.println(current);
			s += current + " ,";
			current = current.next;
		}
		
		if (s.length() > 1)
			s = s.substring(0, s.length()-2);
		
		return s + "]";
		} else {
			return "[]";
		}
	}
	
	private Node<T> findMin(){
		Node<T> current = head.next;
		while (current != null){
			if (current.left == null)
				break;
			current = current.left;
		}
		return current;
	}
}
