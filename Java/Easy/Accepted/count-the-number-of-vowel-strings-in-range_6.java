class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int vowelStrings = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u') {
                if (word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'u') {
                    vowelStrings++;
                }
            }
        }
        return vowelStrings;
    }
}