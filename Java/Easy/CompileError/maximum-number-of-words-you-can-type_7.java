class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        String[] words = text.split(" ");
        it resul = 0;
        for (String word : words) {
            boolean isBroken = false;
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) {
                    isBroken = true;
                    break;
                }
            }
            if (!isBroken) {
                result++;
            }
        }
        return result;
    }
}