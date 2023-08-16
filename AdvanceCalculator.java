import java.util.Scanner;
public class AdvanceCalculator{
	public static void main(String[] args) {
	Scanner lector = new Scanner(System.in);	
	boolean calculator = true;
		while (calculator == true){
			System.out.println("*******Welcome to AdvanceCalculator*******");
            System.out.println("Enter the number corresponding to the option you want to select");
            System.out.println("1. Factorial\n2. Exponentiation\n3. Cosino\n4. Biseccion method\n5. Exit");
			int option = lector.nextInt();
			calculator = menu(option);
		}
	 /**
	 * Method menu: The method returns a boolean value based on the number entered by the user.	 
	 * <br>Pre:<br>The number is an int.
	 * <br>Post:<br>True or false boolean value.
	 * @param int option Number from 1 to 5 that enters a switch statement to determine what to do.
	 * @return boolean It returns a true/false value to determine if the program should continue.
	 */
	}
	public static boolean menu(int option) {
		Scanner lector = new Scanner(System.in);
        switch (option) {
            case 1:
               System.out.println("Enter a number: ");
                int num = lector.nextInt();
                System.out.println(num + "! is equals to " + facto(num));
                break;
            case 2:
                System.out.println("Base number: ");
                double ba = lector.nextInt();
                System.out.println("Exponent number: ");
                int ex = lector.nextInt();
                System.out.println(ba + " raised to " + ex + ", is equal to: " + exponenta(ba, ex));
                break;
            case 3:
				System.out.println("Enter the angle in radians");
				int angle = lector.nextInt();
				System.out.println("The cosine of " + angle + ", is equals to: " + cos(angle));
				break;
			case 4:
				System.out.println("Enter the number corresponding to the option you want to select:");
				System.out.println("1. f(x)=2*cos(x^2)\n2. f(x)=3x^3+7x^2+5\n3. f(x)=xcos(x)");
				option = lector.nextInt();
				bisecmeth(option);
				break;
			case 5:
                return false;
            default:
                System.out.println("Please try again. This number is not avaliable");
                break;
		}	
		System.out.println("Do you want to continue? Enter 1 for YES or 2 for NOT");
        int election = lector.nextInt();
        if (election == 1) {
            return true;
        } else {
            return false;
        }
	 /**
	 * Method facto: The method returns the factorial of a number.
	 * <br>Pre:<br>The number is an int.
	 * <br>Post:<br>Factorial of a number.
	 * @param int num The number for which its factorial will be calculated.
	 * @return returns the factorial of the number.
	 */
	}
	public static double facto(double num){
		double factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
	}
	 /**
	 * Method exponenta: The method returns the power given base and exponent.
	 * <br>Pre:<br>The ex is an int and the ba is a double. 
	 * <br>Post:<br>Multiply the base number of times indicated in the exponent.
	 * @param double ex Number of times the base is multiplied.
	 * @param double ba  The argument that multiplies.
	 * @return returns power of a number.
	 */
	public static double exponenta(double ba, double ex){
		double res = 0;
		res = ba;
        if (ex == 0) {
            res = 1;
        }
        for (int i = 1; i < ex; i++) {
            res *= ba;
        }
        return res;
	}
	 /**
	 * Method cos: The cosino of the angle.
	 * <br>Pre:<br>The angle is a double.
	 * <br>Post:<br>Cosino of the angle.
	 * @param double angle The argument to find the cosine.
	 * @return cosino of the argument.
	 */
	public static double cos(double angle){
		double coseno=0;
		for(int i=0;i<=30;i++){
			coseno += exponenta((-1),i)*exponenta(angle,2*i)/facto(2*i);
		}
		return coseno;
	}
	 /**
	 * Method bisecmeth: This method performs the bisection method to find a root of a function within a given interval.
	 * <br>pre:<br>The option is the number of each function in specific.
	 * <br>post:<br> The root of each function in a determinated interval.
	 * @param option An integer indicating which function to use: 1 for f(x), 2 for g(x), or 3 for h(x).
	 * @return void
	 */
	public static void bisecmeth(int option){
		Scanner lector = new Scanner(System.in);	
		System.out.println("Enter the inicial value");
		double a = lector.nextInt();
		System.out.println("Enter the final value");
		double b = lector.nextInt();
		double epsilon = 0.00001;
		switch (option){
			case 1:
				while (b - a > epsilon) {
					double c = (a + b) / 2; 
					if (f(c) == 0) {
						System.out.println("La raíz es " + c);
						break;
					} else if (f(a) * f(c) < 0) {
						b = c;
					} else {
						a = c;
					}
				}	
				double root = (a + b) / 2;
				System.out.println("La raíz es " + root);
				break;
			case 2:
				while (b - a > epsilon) {
					double c = (a + b) / 2; 
					if (g(c) == 0) {
						System.out.println("The root is: " + c);
						break;
					} else if (g(a) * g(c) < 0) {
						b = c;
					} else {
						a = c;
					}
				}
				root = (a + b) / 2;
				System.out.println("The root is: " + root);
				break;
			case 3:
				while (b - a > epsilon) {
					double c = (a + b) / 2; 
					if (h(c) == 0) {
						System.out.println("The root is: " + c);
						break;
					} else if (h(a) * h(c) < 0) {
						b = c;
					} else {
						a = c;
					}
				}
				root = (a + b) / 2;
				System.out.println("The root is: " + root);
				break;
			default:
			System.out.println("Please try again. This number is not avaliable ");
		}
	}
	 /**
	 * Method f: Calculate the value of the function f(x)=2*cos(x^2).
	 * <br>pre:<br> x to evaluated in f(x).
	 * <br>post:<br> the x in y.
	 * @param x the input value for the function f(x).
	 * @return the value of the function f(x) evaluated at x.
	 */
	public static double f(double x){
		return 2*cos(exponenta(x, 2));
	}
	 /**
	 * Method f: Calculate the value of the function g(x)=3x^3+7x^2+5.
	 * <br>pre:<br> x to evaluated in g(x).
	 * <br>post:<br> the x in y.
	 * @param x the input value for the function g(x).
	 * @return the value of the function g(x) evaluated at x.
	 */	
	public static double g(double x){
		return (3*exponenta(x,3))+(7*exponenta(x,2))+5;
	}
	/**
	 * Method f: Calculate the value of the function h(x)=xcos(x).
	 * <br>pre:<br> x to evaluated in h(x).
	 * <br>post:<br> the x in y.
	 * @param x the input value for the function h(x).
	 * @return the value of the function h(x) evaluated at x.
	 */
	public static double h(double x){
		return x*(cos(x));
	}

	public static double feature1(double x,double y){
		//Feature terminado
		return (x*y)+y;
	}

	public static int feature2(int x, int y) {
		return (x + y) / y;
	}

	public static int feature3(int operacion){
		return operacion*2;
	}
}
