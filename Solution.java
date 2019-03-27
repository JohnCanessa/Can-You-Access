import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;


public class Solution {

	public static void main(String[] args) throws Exception {
		
//		// ???? ????
//		DoNotTerminate.forbidExit();	

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

			// ???? ????
			o = new Inner();
			String str = ((Solution.Inner)o).methodInInner();
			System.out.println("str ==>" + str + "<==\n");
			
			// **** instantiate an object of Solution.Inner.Private class ****
			o = new Inner().new Private();

			// ???? ????
			str = ((Solution.Inner.Private)o).powerof2(num);
			System.out.println("str ==>" + str + "<==\n");
						
			// **** cast to access the classes ****
			Solution.Inner.Private forEaseOfUse = (Solution.Inner.Private)o;
			
			// **** invoke the method (returns a string) ****
			String answer = forEaseOfUse.powerof2(num);
			
			// **** format the output as required ****
			System.out.println(num + " is " + answer);

			// **** ****
			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		
		}//end of try
		
//		// ???? ????
//		catch (DoNotTerminate.ExitTrappedException e) {
//			System.out.println("Unsuccessful Termination!!");
//		}
		
		// ???? ????
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}//end of main
	
	/*
	 * Inner class
	 */
	static class Inner {
		
		/*
		 * the class is called Private
		 * it could have been called Public or InnerInner
		 */
		private class Private {
			
			/*
			 * method in Private class
			 * method in Solution.Inner.Private class
			 */
			private String powerof2(int num){
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
			
		}
		
		/*
		 * method in Inner class
		 * method in Solution.Inner class
		 */
		private String methodInInner() {
			return "method in Inner class";
		}
	}//end of Inner
	
}//end of Solution


///*
// * 
// */
//class DoNotTerminate { //This class prevents exit(0)
//	 
//    public static class ExitTrappedException extends SecurityException {
//
//		private static final long serialVersionUID = 1L;
//    }
// 
//    public static void forbidExit() {
//        final SecurityManager securityManager = new SecurityManager() {
//            @Override
//            public void checkPermission(Permission permission) {
//                if (permission.getName().contains("exitVM")) {
//                    throw new ExitTrappedException();
//                }
//            }
//        };
//        System.setSecurityManager(securityManager);
//    }
//}	