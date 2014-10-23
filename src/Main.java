import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		List<Integer> intSeq = Arrays.asList(1,2,3,4,5);

	    int var = 10;
	    intSeq.forEach(x -> System.out.println(x + var));

	    intSeq.forEach(x -> System.out.println(fact(x)));

	}
	
	public static int fact(int n) {
		if(n == 0) {return 1;} else {return n*fact(n-1);}
	} 

}
