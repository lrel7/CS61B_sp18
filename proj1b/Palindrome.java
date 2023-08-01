public class Palindrome {
    // given a String, return a Deque where the characters appear in the same order as in the String
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> q = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            q.addLast(word.charAt(i));
        }
        return q;
    }

    public boolean isPalindrome(String word) {
        /*if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;*/
        Deque<Character> q = wordToDeque(word);
        while (q.size() > 1) {
            Character first = q.removeFirst();
            Character last = q.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> q = wordToDeque(word);
        while (q.size() > 1) {
            Character first = q.removeFirst();
            Character last = q.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }
}
