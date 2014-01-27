package linear;
import java.util.Iterator;


public class Test {
	public static void main(String[] args){
		CAKLinkedList<Integer> list = new CAKLinkedList<Integer>();
		
		int limit = 400000;
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < limit; i++)
			list.add(0, i);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
		/*
		 * Ineffective remove
		 */
//		start = System.currentTimeMillis();
//		int i = 0;
//		while (i < list.size()){
//			if (list.get(i) % 2 == 0)
//				list.remove(i);
//			else
//				i++;
//		}
//		end = System.currentTimeMillis();
//		System.out.println(end-start);
		
		/*
		 * Effective remove using the iterator()
		 */
		Iterator<Integer> iter = list.iterator();
		start = System.currentTimeMillis();
		while (iter.hasNext()){
			if (iter.next() % 2 == 0)
				iter.remove();
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
