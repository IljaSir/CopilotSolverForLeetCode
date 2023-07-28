class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        for (String token : sentence.split(" ")) {
            if (isValid(token)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isValid(String token) {
        boolean hyphen = false, punctuation = false;
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (Character.isDigit(c)) {
                return false;
            }
            if (c == '-') {
                if (hyphen || i == 0 || i == token.length() - 1) {
                    return false;
                }
                hyphen = true;
            }
            if (c == '!' || c == '.' || c == ',') {
                if (punctuation || i != token.length() - 1) {
                    return false;
                }
                punctuation = true;
            }
        }
        return true;
    }
}