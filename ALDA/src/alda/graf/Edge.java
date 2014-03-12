package alda.graf;

import java.util.ArrayList;
import java.util.Collections;

public class Edge {
	private String name;
	private Node to;
	private int weight;
	private ArrayList<Integer>[] departureTimes = (ArrayList<Integer>[]) new ArrayList[24];
	
	public Edge(String name, Node to, int weight){
		this.name = name;
		this.to = to;
		this.weight = weight;
	}
	
	public boolean addTime(int hour, int minute){
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour can only be 0-23.");
		
		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute can only be 0-59.");
		
		if (departureTimes[hour] == null)
			departureTimes[hour] = new ArrayList<Integer>();
		
		if (departureTimes[hour].add(minute)){
			Collections.sort(departureTimes[hour]);
			return true;
		}
		
		return false;
	}
	
	public int getNextDeparture(int hour, int minute){
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour can only be 0-23.");
		
		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute can only be 0-59.");
		
		ArrayList<Integer> list = departureTimes[hour];
		
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) >= minute)
				return list.get(i);
		}
		
		int nHour = hour + 1;
		int count = 1;
		while (true){
			if (nHour > 23)
				nHour = 0;
			
			if (departureTimes[nHour] != null && !departureTimes[nHour].isEmpty())
				return departureTimes[nHour].get(0) + (count * 60);

			nHour++;
			count++;
		}
	}
	
	public String printNextDep(int hour, int minute){
		int x = getNextDeparture(hour, minute);
		int nextDepHour = hour + x / 60;
		int nextDepMin = x % 60;
		
		return "" + nextDepHour+":"+nextDepMin + " " + this.toString();
	}
	
	public String getAllDepartures(){
		String s = "";
		for (int i = 0; i < departureTimes.length; i++){
			if (departureTimes[i] != null){
				s += i+": ";
				for (Integer j : departureTimes[i]){
					s += j+ " ";
				}
				s += "\n";
			}
		}
		return s;
	}
	
	public Node getDestination(){
		return to;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public String toString(){
		return name + " to " + to + " takes " + weight + " minutes.";
	}
}
