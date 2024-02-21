/**
 * @author longlyMax
 * @version 1.0
 */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        int compare = x - y;
        if (compare == 1 || compare == -1) {
            return true;
        }
        return false;
    }
}
