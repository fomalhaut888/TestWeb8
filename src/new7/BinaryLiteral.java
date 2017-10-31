package new7;

/**
 * Samples for Binary Literals
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html
 */
public class BinaryLiteral {

	public static void main(String[] args) {
			// An 8-bit 'byte' value:
			byte aByte1 = (byte)0b00100001;//2^5 + 1 = 33
			System.out.println("aByte1=" + aByte1);
			// An 16-bit value to a byte integral
			byte aByte2 = (byte)0b0010000100100001;
			System.out.println("aByte2=" + aByte2);
			
			// A 16-bit 'short' value:
			//With 2's complement, 
			// 0b1010000101000101 - 0b0000000000000001 = 0b1010000101000100 
			// inversed as 0b0101111010111011 = 24521, 
			// so the decimal of this binary value is -24521.
			short aShort1 = (short)0b1010000101000101;
			System.out.println("aShort1=" + aShort1);
			// An 32-bit value to a short integral
			short aShort2 = (short)0b10100001010001011010000101000101;
			System.out.println("aShort2=" + aShort2);
			
			// Some 32-bit 'int' values:
			int anInt1 = 0b10100001010001011010000101000101;
			System.out.println("anInt1=" + anInt1);
			int anInt2 = 0b101;//2^2 + 1
			System.out.println("anInt2=" + anInt2);
			int anInt3 = 0B101; // The B can be upper or lower case.
			System.out.println("anInt3=" + anInt3);
			
			// A 64-bit 'long' value. Note the "L" suffix:
			// Without L, a compile error for the literal of type int which is out of range;
			long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;
			System.out.println("aLong=" + aLong);
			
			//Binary literals can make relationships among data more apparent 
			//  than they would be in hexadecimal or octal. 
			//For example, each successive number in the following array is rotated by one bit:
			int[] phases1 = {
					0b00110001,
					0b01100010,
					0b11000100,
					0b10001001,
					0b00010011,
					0b00100110,
					0b01001100,
					0b10011000
			};
			System.out.print("phases1: ");
			for(int i: phases1){
					System.out.print(i + ",");
			}
			System.out.println();
			//In hexadecimal, the relationship among the numbers is not readily apparent:
			int[] phases2 = {
					0x31, 0x62, 0xC4, 0x89, 0x13, 0x26, 0x4C, 0x98
			};
			System.out.print("phases2: ");
			for(int i: phases2){
					System.out.print(i + ",");
			}
			System.out.println();
	}

}
