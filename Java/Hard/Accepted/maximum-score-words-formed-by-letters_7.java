class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] charCount = new int[26];
        for (char c : letters) {
            charCount[c - 'a']++;
        }
        int[] wordScore = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordScore[i] += score[c - 'a'];
            }
        }
        return maxScoreWordsHelper(words, charCount, wordScore, 0);
    }
    private int maxScoreWordsHelper(String[] words, int[] charCount, int[] wordScore, int index) {
        if (index == words.length) {
            return 0;
        }
        int maxScore = 0;
        int[] newCharCount = Arrays.copyOf(charCount, charCount.length);
        boolean isValid = true;
        for (char c : words[index].toCharArray()) {
            if (newCharCount[c - 'a'] == 0) {
                isValid = false;
                break;
            }
            newCharCount[c - 'a']--;
        }
        if (isValid) {
            maxScore = Math.max(maxScore, wordScore[index] + maxScoreWordsHelper(words, newCharCount, wordScore, index + 1));
        }
        maxScore = Math.max(maxScore, maxScoreWordsHelper(words, charCount, wordScore, index + 1));
        return maxScore;
    }
}