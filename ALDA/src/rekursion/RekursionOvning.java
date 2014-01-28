package rekursion;

import java.util.Random;

public class RekursionOvning {
	
	public static void main(String[] args){
		int n = 10;
		
		/*
		 * Summera tal från 1 till n
		 */
		System.out.print("Addera alla tal från 1 till n ("+n+"): ");
		System.out.println(sum(n));
		
		
		/*
		 * Summera tal i en array
		 */
		Random r = new Random();
		System.out.print("\nSummera alla tal i en array: ");
		int[] arr = new int[n];
		for(int i = 0; i<arr.length;i++){
			int x = r.nextInt(100);
			arr[i] = x;
			System.out.print(x+" ");
		}
		System.out.println("\nSumman: "+sum(arr));
		
		/*
		 * Hitta minsta elementet i en array		
		 */
		System.out.print("\nHitta minsta talet i en array: ");
		
		for(int i = 0; i < arr.length; i++){
			int x = r.nextInt(100);
			arr[i] = x;
			System.out.print(x+" ");
		}
		System.out.print("\nMinsta talet: "+findSmallest(arr));
		
		/*
		 * Printa alla tal i ett intervall
		 */
		int start = 5;
		int end = 18;
		System.out.println("\n\nPrinta intervallet "+start+"-"+end+":");
		printInterval(start, end);
		
		/*
		 * Printa alla tal i ett intervall inverst
		 */
		System.out.println("\n\nPrinta intervallet "+start+"-"+end+" baklänges:");
		printIntervalInverse(start, end);
		
	}
	
	public static void printIntervalInverse(int start, int end){
		System.out.print(end+" ");
		if (end == start){
			return;
		}
		
		printIntervalInverse(start, --end);
	}
	
	/*
	 * Gjorde själva.
	 * O(N) <-- Rätt?
	 */
	public static void printInterval(int start, int end){
		System.out.print(start+" ");
		if (start == end){
			return;
		}
		
		printInterval(++start, end);
	}
	
	/*
	 * Lösningsförslaget nedan fungerar på nästan samma sätt, bara en lite annorlunda konstruktion på if-satsen.
	 * O(N) <-- Rätt?
	 public static void printInterval(int start, int end){
	 	if(start <= end){
	 		System.out.println(start);
	 		printInterval(++start, end);
	 	}
	 }
	 */
	
	
	/*
	 * Gjorde själva.
	 * O(N) <-- Rätt?
	 */
	public static int findSmallest(int[] arr, int smallest, int index){
		if (index == arr.length-1)
			return smallest;
		
		if (smallest > arr[index])
			smallest = arr[index];
		
		return findSmallest(arr, smallest, index+1);
		
		/*
		 * Testade att förstå hur förkortade if-else satser fungerade. Fungear också, oklart om det ger någon
		 * bättre prestanda. Förmodligen inte.
		return findSmallest(arr, smallest > arr[index] ? arr[index] : smallest, index+1);
		*/
	}
	
	public static int findSmallest(int[] arr){
		return findSmallest(arr, arr[0], 1);
	}
	
	/*
	 * Gjorde med hjälp av lösningsförslaget.
	 * O(N) <-- Rätt?
	 */
	public static int sum(int n){
		if (n == 1)
			return 1;
		return n + (sum(n-1));
	}
	
	/*
	 * Gjorde själva när vi såg att man kan använda hjälpmetod.
	 * O(N) <-- Rätt?
	 */
	public static int sum(int[] arr, int n){
		if (n == arr.length-1)
			return arr[n];
		
		return arr[n] + sum(arr, n+1);
	}
	
	public static int sum(int[] arr){
		return sum(arr, 0);
	}
	
	
	/*
	 * Gjorde själv, fungerar men väldigt oeffektiv eftersom vi måste göra en ny array varje iteration.
	 * Tänkte inte på att man kan göra en hjälpmetod.
	 * O(N^2) <-- Rätt?
	public static int sum(int[] arr){
		if(arr.length == 1)
			return arr[0];
		
		int[] temp = new int[arr.length-1];
		
		for(int i = 0; i < temp.length; i++)
			temp[i] = arr[i];
		
		return arr[arr.length-1] + sum(temp);
	}
	*/
}
