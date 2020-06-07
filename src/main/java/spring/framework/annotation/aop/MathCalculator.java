package spring.framework.annotation.aop;

public class MathCalculator {

	public int div(int x, int y) {
		System.out.println("MathCalculator...div("+x+","+y+")...");
		return x / y;
	}
	
	public int multiply(int x, int y) {
		System.out.println("MathCalculator...multiply("+x+","+y+")...");
		return x * y;
	}
	
	public int add(int x, int y) {
		System.out.println("MathCalculator...int x, int y("+x+","+y+")...");
		return x + y;
	}
	
	public int subtract(int x, int y) {
		System.out.println("MathCalculator...subtract("+x+","+y+")...");
		return x - y;
	}
}
