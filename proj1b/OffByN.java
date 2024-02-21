/**
 * @author longlyMax
 * @version 1.0
 */
public class OffByN implements CharacterComparator{
    private int comparator;
    public OffByN(int N) {
        comparator = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int compare = x - y;
        if (compare == comparator || compare == (-1 * comparator)) {
            return true;
        }
        return false;
    }
}
