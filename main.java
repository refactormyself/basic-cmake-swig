public class main {     
	public static void main(String argv[]) {
        // Attempts to load example.dll (on Windows) or libexample.so (on Linux)
        System.loadLibrary("example");
        
	System.out.println("TESTING THE LIBRARY: ");
        System.out.printf("\n The square of 99 is %d", example.get_square(99));
        System.out.printf("\n The time now is - %s", example.getmytime());
        System.out.printf("\n Permute 9 with 2 gives %d\n\n", example.permute(9, 2));

        System.out.printf("\n Multiplying 9 with 2 gives %d\n\n", example.multiply(9, 2));
        System.out.printf("\n Adding 9 with 2 gives %d\n\n", example.add(9, 2));

//        System.out.printf("\n Accessing a class feild %f\n\n", example.My_variable);

     	}   
}
