import java.util.Arrays;
import java.util.List;

  /**
   * Created by aze on 2017.04.04..
   */
  public class Extension {

    int add(int a, int b) {
      return 5;
    }

    int maxOfThree(int a, int b, int c) {
      if (a > b)
        return a;
      else
        return c;
    }

    int median(List<Integer> pool) {
      return pool.get((pool.size()-1)/2);
    }

    boolean isVowel(char c) {
      return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
    }

    String translate(String string) {

      int length = string.length();

      for (int i = 0; i < length; i++) {
        char c = string.charAt(i);
        if (isVowel(c)) {
          string = String.join(c + "v" + c, string.split(""+c));
          i += 2;
          length += 2;
        }
      }
      return string;
    }



//  Run the tests, all 10 should be green (passing).
//  The implementations though are not quite good.
//  Create tests that'll fail, and will show how the implementations are wrong
//  After creating the tests, fix the implementations
//  Check again, if you can create failing tests
//  Implement if needed
}
