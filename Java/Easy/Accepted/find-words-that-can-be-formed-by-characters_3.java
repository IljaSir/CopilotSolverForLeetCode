class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            if (canForm(word, charCount)) {
                result += word.length();
            }
        }
        return result;
    }
    
    public boolean canForm(String word, int[] charCount) {
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > charCount[i]) {
                return false;
            }
        }
        return true;
    }
}