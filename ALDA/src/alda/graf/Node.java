package alda.graf;

import java.util.HashMap;
import java.util.HashSet;

public class Node {
	private String name;
	private HashMap<Node, HashSet<Edge>> edges;
	private int x, y;
	
	public Node(String name, int x, int y){
		edges = new HashMap<Node, HashSet<Edge>>();
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String printNextDep(Node n, int hour, int minute){
		Edge e = nextDepartureToNode(n, hour, minute);
		return e.printNextDep(hour, minute);
	}
	
	public Edge nextDepartureToNode(Node to, int currentHour, int currentMinute){
		int lowestTime = Integer.MAX_VALUE;
		Edge fastestEdge = null;
		
		for (Edge e : edges.get(to)){
			int current = e.getNextDeparture(currentHour, currentMinute);
			if (current < lowestTime){
				fastestEdge = e;
				lowestTime = current;
			}
		}
		return fastestEdge;
	}
	
	public boolean addEdge(Node to, Edge e){
		if (!edges.containsKey(to))
			edges.put(to, new HashSet<Edge>());
		
		return edges.get(to).add(e);
	}
	
	public HashSet<Edge> getAllEdges(){
		HashSet<Edge> allEdges = new HashSet<Edge>();
		for (HashSet<Edge> hs : edges.values())
			allEdges.addAll(hs);
		return allEdges;
	}
	
	public HashSet<Edge> getEdgesTo(Node node){
		return new HashSet<Edge>(edges.get(node));
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Object o){
		if (o instanceof Node){
			Node n = (Node)o;
			if (name.equalsIgnoreCase(n.getName())){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return name;
	}
}
