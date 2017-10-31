package new7;

/**
 * Samples for Underscores in Numeric Literals
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/underscores-literals.html
 */
public class UnderscoresInNumberLiterals {

	public static void main(String[] args) {
			//Any number of underscore characters (_) can appear anywhere between digits in a numerical literal.
			long creditCardNumber = 1234_5678_9012_3456L;
			System.out.println("creditCardNumber=" + creditCardNumber);
			long socialSecurityNumber = 999_99_9999L;
			System.out.println("socialSecurityNumber=" + socialSecurityNumber);
			long adwordsCid = 123_456_7890L;
			System.out.println("adwordsCid=" + adwordsCid);
			float pi = 3.14_15F;
			System.out.println("pi=" + pi);
			long hexBytes = 0xFF_EC_DE_5E;
			System.out.println("hexBytes=" + hexBytes);
			long hexWords = 0xCAFE_BABE;
			System.out.println("hexWords=" + hexWords);
			long maxLong = 0x7fff_ffff_ffff_ffffL;
			System.out.println("maxLong=" + maxLong);
			byte nybbles = 0b0010_0101;
			System.out.println("nybbles=" + nybbles);
			long bytes = 0b11010010_01101001_10010100_10010010;
			System.out.println("bytes=" + bytes);
			
			//You can place underscores only between digits; you cannot place underscores in the following places:
			//	- At the beginning or end of a number
			//	- Adjacent to a decimal point in a floating point literal
			//  - Prior to an F or L suffix
			//  - In positions where a string of digits is expected
			//A Compile error 'Underscores have to be located within digits'
			//float pi1 = 3_.1415F;      // Invalid; cannot put underscores adjacent to a decimal point
			//float pi2 = 3._1415F;      // Invalid; cannot put underscores adjacent to a decimal point
			//long socialSecurityNumber1 = 999_99_9999_L;// Invalid; cannot put underscores prior to an L suffix
			//A Compile error '_52 cannot be resolved to a variable'
			//int x1 = _52;// This is an identifier, not a numeric literal
			int x2 = 5_2;// OK (decimal literal)
			System.out.println("x2=" + x2);
			//int x3 = 52_;// Invalid; cannot put underscores at the end of a literal
			int x4 = 5_______2;// OK (decimal literal)
			System.out.println("x4=" + x4);
			//int x5 = 0_x52;// Invalid; cannot put underscores in the 0x radix prefix
			//int x6 = 0x_52;// Invalid; cannot put underscores at the beginning of a number
			int x7 = 0x5_2;// OK (hexadecimal literal)
			System.out.println("x7=" + x7);
			//int x8 = 0x52_;// Invalid; cannot put underscores at the end of a number
			int x9 = 0_52;// OK (octal literal)
			System.out.println("x9=" + x9);
			int x10 = 05_2;// OK (octal literal)
			System.out.println("x10=" + x10);
			//int x11 = 052_;// Invalid; cannot put underscores at the end of a number
	}

}
