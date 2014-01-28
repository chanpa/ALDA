package rekursion;

import java.util.Random;

public class RekursionOvning {
	
	public static void main(String[] args){
		int n = 10;
		
		/*
		 * Summera tal fr�n 1 till n
		 */
		System.out.print("Addera alla tal fr�n 1 till n ("+n+"): ");
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
		System.out.println("\n\nPrinta intervallet "+start+"-"+end+" bakl�nges:");
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
	 * Gjorde sj�lva.
	 * O(N) <-- R�tt?
	 */
	public static void printInterval(int start, int end){
		System.out.print(start+" ");
		if (start == end){
			return;
		}
		
		printInterval(++start, end);
	}
	
	/*
	 * L�sningsf�rslaget nedan fungerar p� n�stan samma s�tt, bara en lite annorlunda konstruktion p� if-satsen.
	 * O(N) <-- R�tt?
	 public static void printInterval(int start, int end){
	 	if(start <= end){
	 		System.out.println(start);
	 		printInterval(++start, end);
	 	}
	 }
	 */
	
	
	/*
	 * Gjorde sj�lva.
	 * O(N) <-- R�tt?
	 */
	public static int findSmallest(int[] arr, int smallest, int index){
		if (index == arr.length-1)
			return smallest;
		
		if (smallest > arr[index])
			smallest = arr[index];
		
		return findSmallest(arr, smallest, index+1);
		
		/*
		 * Testade att f�rst� hur f�rkortade if-else satser fungerade. Fungear ocks�, oklart om det ger n�gon
		 * b�ttre prestanda. F�rmodligen inte.
		return findSmallest(arr, smallest > arr[index] ? arr[index] : smallest, index+1);
		*/
	}
	
	public static int findSmallest(int[] arr){
		return findSmallest(arr, arr[0], 1);
	}
	
	/*
	 * Gjorde med hj�lp av l�sningsf�rslaget.
	 * O(N) <-- R�tt?
	 */
	public static int sum(int n){
		if (n == 1)
			return 1;
		return n + (sum(n-1));
	}
	
	/*
	 * Gjorde sj�lva n�r vi s�g att man kan anv�nda hj�lpmetod.
	 * O(N) <-- R�tt?
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
	 * Gjorde sj�lv, fungerar men v�ldigt oeffektiv eftersom vi m�ste g�ra en ny array varje iteration.
	 * T�nkte inte p� att man kan g�ra en hj�lpmetod.
	 * O(N^2) <-- R�tt?
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
