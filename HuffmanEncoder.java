package Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Heaps.FourWayHeap;
import Heaps.GenericHeap;
import Heaps.Pairingheap;

public class HuffmanEncoder {
	HashMap<Character, String> Encoder;
	HashMap<String, Character> Decoder;

	public HuffmanEncoder(String InString) {
		HashMap<Character, Integer> fMap = new HashMap<>();
		for (int i = 0; i < InString.length(); i++) {
			char cc = InString.charAt(i);
			if (fMap.get(cc) != null) {
				int f = fMap.get(cc);
				f++;
				fMap.put(cc, f);
			} else {
				fMap.put(cc, 1);
			}
		}

		// create min heap
	//	GenericHeap<Node> minHeap = new GenericHeap<Node>();
	//	FourWayHeap<Node> minHeap = new FourWayHeap<Node>();
		Pairingheap<Node>  minHeap = new Pairingheap<Node>();
		Set<Map.Entry<Character, Integer>> entries = fMap.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			Node n = new Node(entry.getKey(), entry.getValue());
			minHeap.push(n);

		}

		// pop out 2 nodes

		while (minHeap.size() != 1)

		{
			Node right = minHeap.pop();
			Node left = minHeap.pop();
			
			Node combined = new Node(right, left);
			combined.data = '\0';
			combined.cost = right.cost+left.cost;
			minHeap.push(combined);
		}
		
		Node ft = minHeap.pop();
	
		this.Encoder = new HashMap<>();
		this.Decoder = new HashMap<>();
		this.initEncoderDecoder(ft, "");

	}

	public String encode(String source) {
		String rv = "";
		for (int i = 0; i < source.length(); i++) {
			String code = this.Encoder.get(source.charAt(i));
			rv = rv + code;
		}
		return rv;
	}

	public String decode(String codedString) {
		String rv = "";
		String key = "";

		for (int i = 0; i < codedString.length(); i++) {
			key = key + codedString.charAt(i);
			if (this.Decoder.containsKey(key)) {
				rv = rv + this.Decoder.get(key);
				key = "";
			}

		}
		return rv;
	}

	private void initEncoderDecoder(Node node, String osf) {
		if (node == null) {
			return;

		}

		if (node.left == null && node.right == null) {
			this.Encoder.put(node.data, osf);
			this.Decoder.put(osf, node.data);

		}

		this.initEncoderDecoder(node.left, osf + "0");
		this.initEncoderDecoder(node.right, osf + "1");
 
	}

	private class Node implements Comparable<Node> {

		char data;
		int cost;  //cost is the frequency
		Node left;
		Node right;

		Node(char data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;

		}

		Node(Node right, Node left) {
			this.right = right;
			this.left = left;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			//return o.cost - this.cost;
			return o.cost - this.cost;
		}
		}
		

	}


