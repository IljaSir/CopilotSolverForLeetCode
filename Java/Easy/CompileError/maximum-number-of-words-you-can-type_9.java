class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        int result = 0;
        for (String word : text.split(" ")) {
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) {
                    result--;
                    break;
                };
            }
        }
        return count;
    }
}