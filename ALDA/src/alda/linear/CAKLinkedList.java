package alda.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;




public class CAKLinkedList<E> implements ALDAList<E> {
	private int modCount = 0;
	private int numberOfElements;
	private Node<E> head;
	private Node<E> tail;
	

	
	public CAKLinkedList(){
		clear();
	}
	
	public void add(E data){
		add(size(), data);
	}
	public void add(int index, E data){
		Node<E>[] arr = getNodes(index);
		
		Node<E> prev = arr[0];
		Node<E> current = arr[1];
		
		Node<E> newNode = new Node<E>(data, current);
		prev.next = newNode;
		
		numberOfElements++;
	}	
	
	public boolean remove(E element){
		int index = indexOf(element);
		
		// That element does not exist
		if (index == -1)
			return false;
			
		remove(index);
		return true;
	}
	public E remove(int index){
		if (index >= size())
			throw new IndexOutOfBoundsException();
		
		Node<E>[] arr = getNodes(index);
		
		Node<E> prev = arr[0];
		Node<E> current = arr[1];
		
		prev.next = current.next;
		
		numberOfElements--;
		return current.data;
	}
	public E remove(Node<E> prev, Node<E> current){
		
		prev.next = current.next;
		
		numberOfElements--;
		return current.data;
	}
	
	public E get(int index){
		if (size() == 0)
			throw new IndexOutOfBoundsException();
		if (index >= size())
			throw new IndexOutOfBoundsException();
		
		Node<E> node = getNodes(index)[1];
		return node.data;
	}
	
	public boolean contains(E element){
		return indexOf(element) != -1;
	}

	public int indexOf(E element){
		Node<E> current = head.next;
		for (int i = 0; i < size(); i++){
			if (current.data.equals(element))
				return i;
			current = current.next;
		}
		
		return -1;
	}

	public void clear(){
		tail = new Node<E>(null, null);
		head = new Node<E>(null, tail);
		
		numberOfElements = 0;
		modCount++;
	}

	public int size(){
		return numberOfElements;
	}
	
	public Iterator<E> iterator(){
		return new CAKLinkedListIterator();
	}
	
	private Node<E>[] getNodes(int index){		
		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException();
		
		Node<E> prev = head;
		Node<E> current = prev.next;
		for (int i = 0; i < index; i++){
			prev = current;
			current = current.next;
		}

		Node<E>[] arr = new Node[2];
		arr[0] = prev;
		arr[1] = current;
		
		return arr;
	}
	
	public String toString(){
		String str = "[";
		
		Node<E> current = head.next;
		for (int i = 0; i < size(); i++){
			str += current.data + ", ";
			current = current.next;
		}
		
		if (str.length() > 1){
			str = str.substring(0, str.length()-2);
		}
		
		return str + "]";
	}
	
	private static class Node<E>{
		Node<E> next;
		E data;
		
		Node(E data, Node<E> next){
			this.next = next;
			this.data = data;
		}
	}
	
	private class CAKLinkedListIterator implements java.util.Iterator<E>{
		private Node<E> prev = null;
		private Node<E> current = head;
		private Node<E> next = current.next;
		
		
		private int expectedModCount = modCount;
		private boolean removeAllowed = false;
		private int i = 0;
		
		public boolean hasNext(){

//			System.out.println(tail+"\n"+current.next+"\n");
			return next != tail;
		}
		
		public E next(){
			if (modCount != expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			
			E nextItem = next.data;
			prev = current;
			current = next;
			next = next.next;
			removeAllowed = true;
			i++;
			return nextItem;
		}
		
		public void remove(){
			if (modCount != expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if (!removeAllowed)
				throw new IllegalStateException();
			
			CAKLinkedList.this.remove(prev, current);
			removeAllowed = false;
		}
	}
	
}
