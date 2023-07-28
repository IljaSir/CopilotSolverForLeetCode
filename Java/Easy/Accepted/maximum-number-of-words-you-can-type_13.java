class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        for (String word : text.split(" ")) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}