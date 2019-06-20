public class main {
     public static void main(String argv[])     {
         // Attempts to load library 
	 System.loadLibrary("sample");
         System.out.println("NOW TRYING TO CALL THE LIBRARY");
	 System.out.printf("\n Permute 9 with 2 gives %d\n\n", sample.permute(9, 2));
     }
   }
