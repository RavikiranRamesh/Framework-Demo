package generic_library;

import java.util.Random;
/**
 * 
 * @author Ravikiran
 * this class is used for getting java methods required for this framework
 */
public class java_utility {
/**
 * used to get random number
 * @return
 */
	public int getRandomnum() {
		Random ram=new Random();
		int random=ram.nextInt();
		return random;
	}
}
