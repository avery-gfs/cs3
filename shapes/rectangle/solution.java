import java.util.*;

class Main {
  public static void main(String[] args) {
    var rect = new Rectangle("Small");

    System.out.println(rect);             // Rectangle(3.0, 4.0)
    System.out.println(rect.width);       // 3.0
    System.out.println(rect.height);      // 4.0
    System.out.println(rect.area());      // 12.0
    System.out.println(rect.perimeter()); // 14.0
  }
}

class Rectangle {
  double width;
  double height;

  Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  double area() {
    return width * height;
  }

  double perimeter() {
    return 2 * width + 2 * height;
  }

  public String toString() {
    return "Rectangle(" + width + ", " + height + ")";
  }
}
