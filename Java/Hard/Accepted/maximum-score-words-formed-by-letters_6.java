class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] letterCount = new int[26];
        for (char c: letters) {
            letterCount[c - 'a']++;
        }
        return backtrack(words, letterCount, score, 0);
    }
    
    private int backtrack(String[] words, int[] letterCount, int[] score, int start) {
        int maxScore = 0;
        for (int i = start; i < words.length; i++) {
            int[] wordCount = new int[26];
            int wordScore = 0;
            for (char c: words[i].toCharArray()) {
                wordCount[c - 'a']++;
                if (wordCount[c - 'a'] > letterCount[c - 'a']) {
                    wordScore = 0;
                    break;
                }
                wordScore += score[c - 'a'];
            }
            if (wordScore > 0) {
                for (int j = 0; j < 26; j++) {
                    letterCount[j] -= wordCount[j];
                }
                maxScore = Math.max(maxScore, wordScore + backtrack(words, letterCount, score, i + 1));
                for (int j = 0; j < 26; j++) {
                    letterCount[j] += wordCount[j];
                }
            }
        }
        return maxScore;
    }
}