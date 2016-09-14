import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implement all methods given in this class using lambda expressions.
 * @author chencc
 *
 */
public class HW21 {
	
	// do not change words!
	final public static List<String> words = Collections.unmodifiableList( 
			    Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios"));
	
	
	/**
	 * Sort words by the length of each word.
	 * Use Collections.sort(List<T>) or Collections.sort(List<T>, Comparator<? super T>)
	 * @return
	 */
	public static List<String> sortWordsByLength() {
		// copy words and sort on the new list.
		List<String> nWords = new ArrayList<>(words) ;
		Collections.sort(nWords,(s1,s2) -> s1.length() - s2.length());
		// sort nWords using Collections.sort
		// Put your code here! ...
		/*Collections.sort(nWords,new Comparator<String>()
				{
				  public int compare(String s1,String s2)
				   {
				    return s1.length() - s2.length();
				    }
				});
		*/ 
		return nWords ;
	}
	
	/**
	 * Sort words by the reverse length of each word, i.e, longest word should be placed at 
	 * the first position.  
	 * @return
	 */
	public static List<String> sortWordsByReverseLength() {
		
		List<String> nWords = new ArrayList<>(words) ;
		
		// sort nWords using Collections.sort
		// Put your code here! ...
		Collections.sort(nWords,(s1,s2) -> s1.length() - s2.length());
		Collections.reverse(nWords);		
				
		return nWords ;
	}
	
	/**
	 * Sort words by the first character occurring in each word.
	 * Empty word should be placed at first position if it appears in words. 
	 * @return
	 */
	public static List<String> sortWordsByFirstChar() {
		
		List<String> nWords = new ArrayList<>(words) ;
		
		// sort nWords using Collections.sort
		// Put your code here! ...
		Collections.sort(nWords);		
				
				
		return nWords ;
	}
	
	/**
	 * sort words by the number of input char c occurring in each word.
	 * @return
	 */
	public static List<String> sortWordsByNumberOfChar(char c ) {
		
		
		// sort nWords using Collections.sort
		// Put your code here! ...
		String cc = String.valueOf(c);
		List<String> nWords = new ArrayList<>(words) ;
		Collections.sort(nWords, (s1, s2) ->  (s1.length()-s1.replaceAll(cc,"").length())-(s2.length()-s2.replaceAll(cc,"").length()));
		   
		
				
		return nWords ;
	}
	
		
//	@FunctionalInterface 
//	interface Util {
//		
//		<T> T betterOne(T s1, T s2, BiPredicate<? super T, ? super T > pred ) ;
//		
//	}
	
	
	
	/**
	 * implement the allMatches method which will return true if all elements of the input list pass the
	 * pred.test method  
	 * @param list : list of element to be test
	 * @param pred : the predicate
	 * @return true iff all elements of list pass the predicate test. 
	 */
	 public static  <T> boolean allMatches(List<T> list, Predicate<? super T> pred){
		
		 return list.stream().allMatch(pred);
	}
	 
	 
	 /**
	  * Make a static method called transformList.
	  * It should take a List<T> l and a Function<? super T, U> f and
	  * return a new List { f(e) | e in l } of type List<U> that contains the results of applying the Function
	  * to each element of the original List. E.g.:
	  * List<String> excitingWords = transformList(words, s -> s + "!");
	  * List<String> eyeWords = transformList(words, s -> s.replace("i", "eye"));
	  * List<String> upperCaseWords = transformList(words, String::toUpperCase);
	  */
	 
	 public static <T,U> List<U> transformList(List<T> list, Function<? super T, U> f){
		 return list.stream().map(f).collect(Collectors.toList()) ;
	 }
	
	
	

	public static void main(String[] args) {
		
		System.out.println(sortWordsByLength()) ;
		
		System.out.println(sortWordsByReverseLength()) ;
		
		System.out.println(sortWordsByFirstChar()) ;
		
		System.out.println(sortWordsByNumberOfChar('o')) ;
		
		System.out.println(allMatches(words, w -> w.length()>0 && w.length() < 10  )) ;
		
		System.out.println(allMatches(words, w -> w.contains("b") )) ;
		
		System.out.println(transformList(words, String::toUpperCase));
		
		

	}

}