import org.junit.Test;

/**
 * @author longlyMax
 * @version 1.0
 */
public class TestOffByN {

    @Test
    public void test() {
        OffByN offBy5 = new OffByN(5);
        System.out.println(offBy5.equalChars('a', 'f'));  // true
        offBy5.equalChars('f', 'a');  // true
        System.out.println(offBy5.equalChars('f', 'a'));  // true);
        System.out.println(offBy5.equalChars('f', 'h'));  // true);

        offBy5.equalChars('f', 'h');  // false
    }
}
