class Solution {
    public int countValidWords(String sentence) {
        
        int wordCount = 0;
        boolean valid = true;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                if (valid) {
                    wordCount++;
                }
                valid = true;
            } else if (c == '-') {
                if (i == 0 || i == sentence.length() - 1 || sentence.charAt(i - 1) == ' ' || sentence.charAt(i + 1) == ' ') {
                    valid = false;
                }
            } else if (c == '.' || c == ',' || c == '!') {
                if (i != sentence.length() - 1) {
                    valid = false;
                }
            } else if (c >= '0' && c <= '9') {
                valid = false;
            }
        }
        if (valid) {
            wordCount++;
        }
        return wordCount;
    }
}