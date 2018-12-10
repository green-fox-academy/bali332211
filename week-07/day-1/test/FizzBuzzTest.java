import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {




  @Test
  public void test() {
      assertEquals("Fizz", FizzBuzz.getFizzBuzzValue(3));
      assertEquals("Buzz", FizzBuzz.getFizzBuzzValue(5));
      assertEquals("FizzBuzz", FizzBuzz.getFizzBuzzValue(15));

  }


}
