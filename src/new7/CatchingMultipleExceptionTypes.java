package new7;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JDK 7 New: Catching Multiple Exception Types and Rethrowing Exceptions with Improved Type Checking
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/catch-multiple.html
 */
public class CatchingMultipleExceptionTypes {

	public static void main(String[] args) throws IOException, SQLException {
			//1. Handling More Than One Type of Exception
			try{
					if(args[0].equals("1")){
							throw new IOException("test");
					}else if(args[0].equals("2")){
							throw new SQLException("test");
					}
			//In releases prior to Java SE 7
			}catch(IOException ex){
					System.out.println("Exception:" + ex);//duplicate code
					throw ex;//duplicate code
			}catch(SQLException ex){
					System.out.println("Exception:" + ex);//duplicate code
					throw ex;//duplicate code
			}
			
			try{
					if(args[0].equals("3")){
							throw new IOException("test");
					}else if(args[0].equals("4")){
							throw new SQLException("test");
					}
			//In Java SE 7 and later, eliminates the duplicated code
			//The catch clause specifies the types of exceptions that the block can handle, 
			//    and each exception type is separated with a vertical bar (|).
			//Note: The catch parameter ex is final 
			//		and therefore you cannot assign any values to it within the catch block.
			//Bytecode generated by compiling a catch block that handles multiple exception types 
			//    will be smaller (and thus superior) than compiling many catch blocks that handle only one exception type each.
			}catch(IOException | SQLException ex){
					//ex = new SQLException("");//Compile Error: The parameter ex of a multi-catch block cannot be assigned.
					System.out.println("Exception:" + ex);//eliminates the duplicated code
					throw ex;	
			}			
	}
	
	//2. Rethrowing Exceptions with More Inclusive Type Checking
	//In releases prior to Java SE 7, only throw Exception in this condition.
	public void rethrowException(String exceptionName) throws Exception {
			try {
					if (exceptionName.equals("First")) {
							throw new FirstException();
					} else {
							throw new SecondException();
					}
			} catch (Exception e) {
					throw e;
			}
	}
	
	//In Java SE 7 and later, performs more precise analysis of rethrown exceptions than earlier releases of Java SE.
	//You can rethrow FirstException, SecondException
	public void rethrowException2(String exceptionName) throws FirstException, SecondException {//rethrow FirstException, SecondException
			try {
					if (exceptionName.equals("First")) {
							throw new FirstException();
					} else {
							throw new SecondException();
					}
			} catch (Exception e) {
					//This analysis is disabled if the catch parameter is assigned to another value in the catch block.
					//e = new FirstException();//If you add this line, Compile Error: Unhandled exception type Exception
					throw e;
			}
	}

	private static class FirstException extends Exception { }
	private static class SecondException extends Exception { }
}
