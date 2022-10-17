package extra.classExample.example;

public class Circle extends Shape {

	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	@Override
	public String toString() {
		return String.format("원, %f, %f", perimeter(), area());
	}
	
}
