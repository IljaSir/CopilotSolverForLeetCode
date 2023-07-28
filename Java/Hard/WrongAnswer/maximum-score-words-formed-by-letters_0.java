class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        return dfs(words, count, score, 0);
    }

    private int dfs(String[] words, int[] count, int[] score, int i) {
        if (i == words.length) {
            return 0;
        }
        int max = 0;
        int[] copy = Arrays.copyOf(count, count.length);
        int score1 = dfs(words, count, score, i + 1);
        int score2 = 0;
        boolean valid = true;
        for (char c : words[i].toCharArray()) {
            if (count[c - 'a'] == 0) {
                valid = false;
                break;
            }
            count[c - 'a']--;
            score2 += score[c - 'a'];
        }
        if (valid) {
            score2 += dfs(words, count, score, i + 1);
        }
        max = Math.max(max, Math.max(score1, score2));
        System.arraycopy(copy, 0, count, 0, count.length);
        return max;
    }
}