package alda.graf;

import java.util.HashSet;
import java.util.Set;

public class CAKGraph implements Graph{
	private HashSet<Node> nodes;

	public CAKGraph(){
		nodes = new HashSet<Node>();
	}

	@Override
	public boolean add(Node node) {
		return nodes.add(node);
	}

	@Override
	public boolean connect(Node from, Node to, String name, int weight) {
		if (!nodes.contains(from) || !nodes.contains(to))
			throw new IllegalArgumentException("One of the nodes does not exist.");

		if (name.isEmpty())
			throw new IllegalArgumentException("The name can't be empty.");

		if (weight < 0)
			throw new IllegalArgumentException("The time can't be negative.");

		return from.addEdge(to, new Edge(name, to, weight));
	}

	public String findPath(Node from, Node to){
		if (!nodes.contains(from) || !nodes.contains(to))
			throw new IllegalArgumentException("One of the nodes does not exist.");

		if (!pathExists(this, from, to))
			return "There is no path between those nodes.";
		else {
			return getPath(this, from, to, new HashSet<Node>()).toString();
		}
	}

	private Set<Node> getPath(CAKGraph g, Node n, Node to, Set<Node> visited){
		visited.add(n);
		Node next = null;
		for (Edge e : g.getEdgesFrom(n)){
			if (!visited.contains(to)){
				next = e.getDestination();
				getPath(g, next, to, visited);
			}
		}

		return visited;
	}

	private static void dfs(CAKGraph g, Node n, Set<Node> visited){
		visited.add(n);
		Node next = null;
		for (Edge e : g.getEdgesFrom(n)){
			if (!visited.contains(e.getDestination())){
				next = e.getDestination();
				dfs(g, next, visited);
			}
		}

	}

	private boolean pathExists(CAKGraph g, Node from, Node to){
		Set<Node> visited = new HashSet<Node>();
		dfs(g, from, visited);
		return visited.contains(to);
	}

	@Override
	public HashSet<Edge> getEdgesFrom(Node node) {
		return node.getAllEdges();
	}

	@Override
	public void setConnectionWeight(Node from, Node to, String name, int weight) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Edge> getEdgesBetween(Node n1, Node n2) {
		// TODO Auto-generated method stub
		return null;
	}


}
