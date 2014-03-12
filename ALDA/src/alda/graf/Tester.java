package alda.graf;

public class Tester {
	public static void main(String[] args){
		CAKGraph graf = new CAKGraph();
		Node	tc = new Node("T-centralen", 50, 50),
				ki = new Node("Kista", 5, 5),
				k1 = new Node("Kista1", 6, 5),
				k2 = new Node("Kista2", 7, 5),
				fo = new Node("Foobar", 0, 0);



		graf.add(tc);
		graf.add(ki);
		graf.add(k1);
		graf.add(k2);
		graf.add(fo);

		Edge e1 = new Edge("buss", ki,  10);
		Edge e2 = new Edge("buss", fo, 2);
		Edge e3 = new Edge("tub", ki, 10);

		for (int i = 0; i < 24; i++){
			for (int j = 5; j < 60; j = j + 10){
				e1.addTime(i, j);
				e2.addTime(i, j);
				e3.addTime(i, j-3);
			}
		}
		tc.addEdge(ki, e1);
		tc.addEdge(ki, e3);
		ki.addEdge(fo, e2);
		System.out.println(e3.getAllDepartures());
		
		
		//		graf.connect(tc, ki, "buss", 10);
		//		graf.connect(ki, fo, "buss", 4);

		System.out.println(tc.printNextDep(ki, 15, 11));

		System.out.println(graf.findPath(tc, fo));
	}
}
