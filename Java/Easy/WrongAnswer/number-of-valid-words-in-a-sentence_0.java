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

    private boolean isValidWord(String word) {
        int hyphenCount = 0;
        int punctuationCount = 0;
        for (char c : word.toCharArray()) {
            if (c == '-') {
                hyphenCount++;
            } else if (c == '!' || c == '.' || c == ',') {
                punctuationCount++;
            } else if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return hyphenCount <= 1 && punctuationCount <= 1;
    }
}