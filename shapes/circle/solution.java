import java.util.*;
import java.lang.Math;

class Main {
  public static void main(String[] args) {
    var circle = new Circle(5.0);

    System.out.println(circle);             // Circle(5.0)
    System.out.println(circle.radius);      //  5.0
    System.out.println(circle.area());      // 78.5
    System.out.println(circle.perimeter()); // 31.4

    var unitCircle = new Circle();
    System.out.println(unitCircle);         // Circle(1.0)
  }
}

class Circle {
  double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  Circle() {
    this.radius = 1.0;
  }

  double area() {
    return Math.PI * radius * radius;
  }

  double perimeter() {
    return 2 * Math.PI * radius;
  }

  public String toString() {
    return "Circle(" + radius + ")";
  }
}
