package test.internationalization.unicode;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 1.Java 8 new features: Internationalization 1: Unicode Enhancements, including support for Unicode 6.2.0.<br>
 * 2.This is a Test Case.<br>
 * @author SimonC
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnicodeEnhancementsTC {

	/**
	 * Turish Lira Sign: 土耳其和北賽普路斯的貨幣符號,三字元碼為TRY.
	 * @see <a href="https://en.wikipedia.org/wiki/Turkish_lira_sign" target="_blank">維基百科</a>
	 */
	@Test
	public void show01TurishLiraSign() {
			char turkishLiraSign = '\u20BA';
			System.out.println("Turkish lira sign = " + turkishLiraSign);
			System.out.println("##########Turish Lira Sign########################################");
			System.out.println();
	}

	/**
	 * A new script: Meroitic Hieroglyphs
	 * @see <a href="https://en.wikipedia.org/wiki/Meroitic_Hieroglyphs_(Unicode_block)" target="_blank">維基百科</a>
	 */
	@Test
	public void show02MeroiticHieroglyphs(){
			for(int i = 0x10980; i <= 0x1099F; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Meroitic Hieroglyphs########################################");
			System.out.println();
	}
	
	/**
	 * A new script: Meroitic Cursive
	 * @see <a href="https://en.wikipedia.org/wiki/Meroitic_Cursive_(Unicode_block)" target="_blank">維基百科</a>
	 */
	@Test
	public void show03MeroiticCursive(){
			for(int i = 0x109A0; i <= 0x109FF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Meroitic Cursive########################################");
			System.out.println();
	}
	
	/**
	 * A new script: Sora Sompeng
	 * @see <a href="https://en.wikipedia.org/wiki/Sora_Sompeng_(Unicode_block)" target="_blank">維基百科</a>
	 */
	@Test
	public void show04SoraSompeng(){
			for(int i = 0x110D0; i <= 0x110FF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Sora Sompeng########################################");
			System.out.println();
	}
	
	/**
	 * A new script: Chakma
	 * @see <a href="https://en.wikipedia.org/wiki/Chakma_(Unicode_block)" target="_blank">維基百科</a>
	 */
	@Test
	public void show05Chakma(){
			for(int i = 0x11100; i <= 0x1114F; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Chakma########################################");
			System.out.println();
	}
	
	/**
	 * A new script: Sharada
	 * @see <a href="https://en.wikipedia.org/wiki/Sharada_(Unicode_block)" target="_blank">維基百科</a>
	 */
	@Test
	public void show06Sharada(){
			for(int i = 0x11180; i <= 0x111DF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Sharada########################################");
			System.out.println();
	}
	
	/**
	 * A new script: Takri
	 * @see <a href="https://en.wikipedia.org/wiki/Takri_(Unicode_block)" target="_blank">維基百科</a>
	 */
	@Test
	public void show07Takri(){
			for(int i = 0x11680; i <= 0x116CF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Takri########################################");
			System.out.println();
	}
	
	/**
	 * A new script: Miao
	 * @see <a href="https://en.wikipedia.org/wiki/Miao_(Unicode_block)" target="_blank">維基百科</a>
	 */
	@Test
	public void show08Miao(){
			for(int i = 0x16F00; i <= 0x16F9F; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Miao########################################");
			System.out.println();
	}
	
	/**
	 * A new block: Arabic Extended-A
	 * @see <a href="https://en.wikipedia.org/wiki/Arabic_Extended-A" target="_blank">維基百科</a>
	 */
	@Test
	public void show09ArabicExtended_A(){
			for(int i = 0x08A0; i <= 0x08FF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Arabic Extended-A########################################");
			System.out.println();
	}
	
	/**
	 * A new block: Sundanese Supplement
	 * @see <a href="https://en.wikipedia.org/wiki/Sundanese_Supplement" target="_blank">維基百科</a>
	 */
	@Test
	public void show10SundaneseSupplement(){
			for(int i = 0x1CC0; i <= 0x1CCF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Sundanese Supplement########################################");
			System.out.println();
	}
	
	/**
	 * A new block: Meetei Mayek Extensions
	 * @see <a href="https://en.wikipedia.org/wiki/Meetei_Mayek_Extensions" target="_blank">維基百科</a>
	 */
	@Test
	public void show11MeeteiMayekExtensions(){
			for(int i = 0xAAE0; i <= 0xAAFF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Meetei Mayek Extensions########################################");
			System.out.println();
	}
	
	/**
	 * A new block: Arabic Mathematical Alphabetical Symbols
	 * @see <a href="https://en.wikipedia.org/wiki/Arabic_Mathematical_Alphabetic_Symbols" target="_blank">維基百科</a>
	 */
	@Test
	public void show12ArabicMathematicalAlphabeticalSymbols(){
			for(int i = 0x1EE00; i <= 0x1EEFF; i++){
					char c = (char)i;
					System.out.print(c + "  ");
					if(i % 16 == 15){
							System.out.println();
					}
			}
			System.out.println();
			System.out.println("##########Arabic Mathematical Alphabetical Symbols########################################");
			System.out.println();
	}
}
