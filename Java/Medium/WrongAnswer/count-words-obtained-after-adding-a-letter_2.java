class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;
        for (String targetWord : targetWords) {
            for (String startWord : startWords) {
                if (canConvert(startWord, targetWord)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private boolean canConvert(String startWord, String targetWord) {
        if (startWord.length() > targetWord.length()) {
            return false;
        }
        if (startWord.length() < targetWord.length()) {
            return canConvert(startWord, targetWord.substring(0, targetWord.length() - 1));
        }
        int[] startWordCharCount = new int[26];
        for (char c : startWord.toCharArray()) {
            startWordCharCount[c - 'a']++;
        }
        int[] targetWordCharCount = new int[26];
        for (char c : targetWord.toCharArray()) {
            targetWordCharCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (targetWordCharCount[i] > startWordCharCount[i]) {
                return false;
            }
        }
        return true;
    }
}