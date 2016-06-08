package com.tigerit.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	private int value;
	private int count;
	private ArrayList<Integer> linkedValues;
	private HashMap<Integer, Node> links;
	
	public Node(int value) {
		this.value = value;
		count = 0;
		linkedValues = new ArrayList<>();
		links = new HashMap<>();
	}
	
	public Node findNode(int value) {
		if (links.containsKey(value)) {
			return links.get(value);
		} else {
			return null;
		}
	}
	
	public void insertNode(Node node) {
		if (links.containsKey(node.value)) return;

		linkedValues.add(node.value);
		links.put(node.value, node);
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void increaseCount() {
		this.count++;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the linkedValues
	 */
	public ArrayList<Integer> getLinkedValues() {
		return linkedValues;
	}

	/**
	 * @return the links
	 */
	public HashMap<Integer, Node> getLinks() {
		return links;
	}
	
}
