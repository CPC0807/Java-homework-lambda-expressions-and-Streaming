	import java.util.Arrays;
import java.util.List;


import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Implement all methods given in this class using the Streaming API.
 * @author chencc
 *
 */
public class HW22 {
	
	public static List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
	
	
	/**
	 * 1. Generate a Stream object from words
	 * 2. use forEach(lambda) to print each word in words to the console,
	 * 3. Each word should be printed on a separate line, with two spaces in front of each word
	 */
	public static void printWords() {//完成
		
		// Stream<String> strm =  ?
		Stream<String> strm = words.stream();
		// strm .forEach(???) ;
		strm.peek(s -> System.out.print("  ")).forEach(System.out::println);
		
	}
	
	/**
	 * 1. Generate a Stream object from words	  
	 * 2. use forEach(methodRef) to print each word in words to the console, where the input methodRef to forEach should be a method reference.
	 * 3. Each word should be printed on a separate line. 
	 */
	public static void printWords2() {//完成
		
		Stream<String> strm = words.stream();
		strm.forEach(System.out::println);
	}
	
	/**
	 * 1. Generate a Stream<String> object from words	  
	 * 2. use map() to generate another Stream { s + "!" | s in original stream } 
	 * 3. convert the mapped stream into a list.
	 * 4. Ex: ["Ab", "bc"] --> ["Ab!", "bc!"] 
	 */
	public static List<String> words2suprisingWords() {
		List<String> list = words.stream().map(p -> p + "!" ).collect(toList());
		return list ;		
	}
	
	/**
	 * 1. Generate a Stream<String> object from ws	  
	 * 2. use 3 calls of filter() to passing all strings s that satisfy the conditions: 
	 * <ol>
	 *  <li> s .length is less than 6 </li>
	 *  <li> s contains 'e' </li>
	 *  <li> s is of odd length </li>
	 * </ol> 
	 * 3. Ex: ["cbe", "ec", "ddeef" ] --> ["cbe", "ddeef"] 
	 */
	public static List<String> FindAllwordsPassingASeqOfTests(String[] ws ) {//完成
		
		List<String> list = Arrays.stream(ws).filter( n -> n.length() <= 6).filter( n -> n.contains("e") ).filter(n -> n.length() % 2 == 1).collect(toList());
		return list ;
	}
	
	

	/**
	 *  use the Stream.reduce() method to generate a string which is the concatenation of uppercase versions of all words in ws.
	 *  Ex: ws=["abS", "deF"] --> return "ABSDEF"
	 * @param ws
	 * @return
	 */
	public static String words2UpperCaseWord(List<String> ws){//完成
		Stream<String> strm =ws.stream();
		String s = strm.map(String::toUpperCase).collect(Collectors.joining()).toString();
		return s ;
	}
	
	/**
	 * Produce a String that is all the words concatenated together, but with commas in between.
	 * E.g., the result should be "hi,hello,...". Note that there is no comma at the beginning, before
	 * "hi", and also no comma at the end, after the last word.
	 * 	 
	 */
	public static String words2UpperCaseWord2(List<String> ws){//完成
		Stream<String> strm =ws.stream();
		//strm.peek(System.out::print).forEach(s -> System.out.print(","));
		String s = strm.collect(Collectors.joining(",")).toString();
		//System.out.print(s);
		return s ;
	}
	
	
	/**
	 * Make a static method that produces a list of numbers that go in order by a step size.
	 * E.g.: orderedNumberList(10,3,4) --> [10, 13, 16, 19]
	 * 
	 * @param args
	 */
	public static List<Integer> orderedNumberList(int start, int step , int size){
	
		List<Integer> list = Stream.iterate(start,n ->n+step).limit(size).collect(toList());
		return list ;
	}
	

	public static void main(String[] args) {
		  
		    System.out.println("Words (with spaces):");
		    printWords() ;  
		    
		    		    
		    System.out.println("Words (no spaces):");
		    printWords2();
		    
		    
		    
		    System.out.print("Words2SurprisingWords:");
		    System.out.println(words2suprisingWords()) ;
		    
		    System.out.print("wordsPassingASeqOfTests:");
		    System.out.println(FindAllwordsPassingASeqOfTests(
		    		new String[]{"abcdefg", "dces", "dde", "facde"}
		    		)) ;
		    
		    System.out.print("words2UpperCaseWord:");
		    System.out.println(words2UpperCaseWord(words)) ;
		    System.out.print("words2UpperCaseWord2:");
		    System.out.println(words2UpperCaseWord2(words)) ;
		    System.out.print("orderedNumberList:");
		    System.out.println(orderedNumberList(10, 4, 4)) ;
		    
		    
		    
		    
		    
		    	    
		       
		    
		   
		   
		   
		  
		


	}

}