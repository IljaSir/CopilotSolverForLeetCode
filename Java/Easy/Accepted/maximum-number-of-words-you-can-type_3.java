class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        int result = 0;
        for (String word : text.split(" ")) {
            boolean ok = true;
            for (char c : word.toCharArray()) {
                if (set.contains(c)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                result++;
            }
        }
        return result;
    }
}