import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

  @Test
  public void numbers() {
    Fibonacci fibonacci = new Fibonacci();
    assertEquals(13, fibonacci.numbers(7));
  }
}
