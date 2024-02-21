/**
 * @author longlyMax
 * @version 1.0
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character part = word.charAt(i);
            res.addLast(part);
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        //得到deque，每一项存储的是一个字符
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character part = word.charAt(i);
            res.addLast(part);
        }

        //得到倒叙串
        String palid = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            palid += res.removeLast();
        }

        //正序与倒序比较
        for (int i = 0; i < word.length(); i++) {
            int compare = Character.compare(word.charAt(i), palid.charAt(i));
            if (compare != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        //得到deque，每一项存储的是一个字符
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character part = word.charAt(i);
            res.addLast(part);
        }

        //得到倒叙串
        String palid = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            palid += res.removeLast();
        }

        //调用比较器的方法进行判断
        for (int i = 0; i < word.length(); i++) {
            if (!cc.equalChars(word.charAt(i), palid.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
