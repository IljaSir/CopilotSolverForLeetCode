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
                if (i == 0 || i == word.length() - 1) {
                    return false;
                }
                char prevChar = word.charAt(i - 1);
                char nextChar = word.charAt(i + 1);
                if (!Character.isLowerCase(prevChar) || !Character.isLowerCase(nextChar)) {
                    return false;
                }
                hasHyphen = true;
            } else if (c == '!' || c == '.' || c == ',') {
                if (hasPunctuation) {
                    return false;
                }
                if (i != word.length() - 1) {
                    return false;
                }
                hasPunctuation = true;
            } else if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}