package alda.graf;

import java.util.*;

public interface Graph {
	public boolean add(Node node);
	public boolean connect(Node from, Node to, String name, int weight);
	public HashSet<Edge> getEdgesFrom(Node node);
//	public void disconnect(Node n1, Node n2);
//	public List<Node> getNodes();
//	public void removeNode (Node node);
	public String toString();
	public void setConnectionWeight(Node from, Node to, String name, int weight);
	public Set<Edge> getEdgesBetween(Node n1, Node n2);
}