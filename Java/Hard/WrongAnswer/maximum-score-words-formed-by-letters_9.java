class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] letterCounts = new int[26];
        for (char c : letters) {
            letterCounts[c - 'a']++;
        }
        return backtrack(words, letterCounts, score, 0);
    }
    
    private int backtrack(String[] words, int[] letterCounts, int[] score, int start) {
        int maxScore = 0;
        for (int i = start; i < words.length; i++) {
            int scoreForWord = getScore(words[i], score, letterCounts);
            if (scoreForWord > 0) {
                maxScore = Math.max(maxScore, scoreForWord + backtrack(words, letterCounts, score, i+1));
            }
        }
        return maxScore;
    }
    
    private int getScore(String word, int[] score, int[] letterCounts) {
        int[] wordCounts = new int[26];
        for (char c : word.toCharArray()) {
            wordCounts[c - 'a']++;
        }
        int totalScore = 0;
        for (int i = 0; i < 26; i++) {
            if (wordCounts[i] > letterCounts[i]) {
                return 0;
            }
            totalScore += score[i] * wordCounts[i];
        }
        for (int i = 0; i < 26; i++) {
            letterCounts[i] -= wordCounts[i];
        }
        return totalScore;
    }
}