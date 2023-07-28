class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;
        for (int i = 0; i < targetWords.length; i++) {
            for (int j = 0; j < startWords.length; j++) {
                if (isPossible(startWords[j], targetWords[i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    boolean isPossible(String startWord, String targetWord) {
        if (startWord.length() > targetWord.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < startWord.length(); i++) {
            freq[startWord.charAt(i) - 'a']++;
        }
        for (int i = 0; i < targetWord.length(); i++) {
            freq[targetWord.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return false;
            }
        }
        return true;
    }
}