class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        return dfs(words, letterCount, score, 0);
    }
    
    private int dfs(String[] words, int[] letterCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        int[] curCount = new int[26];
        int scoreWith = 0;
        boolean valid = true;
        for (char c : words[index].toCharArray()) {
            curCount[c - 'a']++;
            if (curCount[c - 'a'] > letterCount[c - 'a']) {
                valid = false;
                break;
            }
            scoreWith += score[c - 'a'];
        }
        int without = dfs(words, letterCount, score, index + 1);
        if (!valid) {
            return without;
        }
        for (int i = 0; i < 26; i++) {
            letterCount[i] -= curCount[i];
        }
        int with = scoreWith + dfs(words, letterCount, score, index + 1);
        for (int i = 0; i < 26; i++) {
            letterCount[i] += curCount[i];
        }
        return Math.max(with, without);
    }
}