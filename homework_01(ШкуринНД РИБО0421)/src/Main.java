import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Output and input
        System.out.println("Practical task №1. Variant 1. Student Шкурин Н.Д. Group РИБО-04-21.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the 1st side: ");
        float firstSide = scanner.nextFloat();
        System.out.print("Enter the 2nd side: ");
        float secondSide = scanner.nextFloat();
        System.out.print("Enter the 3rd side(If you have a rectangle just enter '0'): ");
        float thirdSide = scanner.nextFloat();

        if (firstSide < 0 || secondSide < 0 || thirdSide < 0)
            System.out.println("The sides cannot be < 0");
        else {
            // Сhecking for a triangle
            if (thirdSide == 0) {
                System.out.println("The area of the rectangle = " + findArea(firstSide, secondSide));
                System.out.println("The perimeter of the rectangle = " + findPerimeter(firstSide, secondSide));
            }
            else {

                float perimeter = findPerimeter(firstSide, secondSide, thirdSide);
                double triangleArea = findArea(firstSide, secondSide, thirdSide, perimeter);
                // error message
                if (triangleArea == 0.0)
                    System.out.println("Check the entered sides!!! ");

                else {
                    System.out.println("The area of the triangle = " + triangleArea);
                    System.out.println("The perimeter of the triangle = " + findPerimeter(firstSide, secondSide,
                            thirdSide));
                }
            }
        }

    }

    public static float findPerimeter(float firstSide, float secondSide, float thirdSide){
        /* finds the perimeter of the triangle */
        return firstSide + secondSide + thirdSide;
    }
    public static float findPerimeter(float firstSide, float secondSide){
        /* finds the perimeter of the rectangle */
        return 2 * (firstSide + secondSide);
    }
    public static double findArea(float firstSide, float secondSide, float thirdSide, float perimeter){
        /* finds the area of the triangle */
        float halfPerimeter = perimeter / 2;

        // checking correctness
        if ((halfPerimeter - firstSide < 0) || (halfPerimeter - secondSide < 0) || (halfPerimeter - thirdSide < 0)){
            System.out.println("There is no triangle with such sides!");
            return 0.0;

        }else {
            return Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) *
                    (halfPerimeter - thirdSide));
        }
    }
    public static double findArea(float firstSide, float secondSide){
        /* finds the area of the rectangle */
        return firstSide * secondSide;
    }
}
