import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        OffByOne obo = new OffByOne();
        System.out.println(obo.equalChars('a', 'b'));
//        obo.equalChars('r', 'q');
//        obo.equalChars('a', 'e');
        System.out.println(obo.equalChars('&', '%'));
        obo.equalChars('z', 'a');
//        obo.equalChars('a', 'a');
    }
//    Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
}
