package Tries;

public class HeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		String str = "Hello My name is Shubham %^#";

		HuffmanEncoder hf = new HuffmanEncoder(str);
		String code = hf.encode(str);
		System.out.println(code);
		String output = hf.decode(code);
		System.out.println(output);

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);

	}

}
