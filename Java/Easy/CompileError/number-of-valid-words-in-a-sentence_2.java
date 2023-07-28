class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (isValidWord(word)) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isValidWord(String word) {
        if (word.length() == 0) {
            return false;
        }
        boolean hasHyphen = false;
        boolean hasPunctuation = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                return false;
            } else if (c == '-') {
                if (hasHyphen) {
                    return false;
                }
                    return false;
                }
                punctuation = true;
            }
        }
        return true;
    }
}