class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        return dfs(words, 0, letterCount, score);
    }
    private int dfs(String[] words, int start, int[] letterCount, int[] score) {
        int max = 0;
        for (int i = start; i < words.length; i++) {
            int[] newLetterCount = new int[26];
            int curScore = 0;
            for (char c : words[i].toCharArray()) {
                newLetterCount[c - 'a']++;
                if (newLetterCount[c - 'a'] > letterCount[c - 'a']) {
                    curScore = 0;
                    break;
                }
                curScore += score[c - 'a'];
            }
            if (curScore > 0) {
                for (int j = 0; j < 26; j++) {
                    letterCount[j] -= newLetterCount[j];
                }
                max = Math.max(max, curScore + dfs(words, i + 1, letterCount, score));
                for (int j = 0; j < 26; j++) {
                    letterCount[j] += newLetterCount[j];
                }
            }
        }
        return max;
    }
}