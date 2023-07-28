class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] freq = new int[26];
        for (char c : letters) {
            freq[c - 'a']++;
        }
        return dfs(words, 0, freq, score);
    }
    private int dfs(String[] words, int index, int[] freq, int[] score) {
        if (index == words.length) {
            return 0;
        }
        int max = 0;
        int[] freqCopy = Arrays.copyOf(freq, freq.length);
        int scoreCopy = 0;
        for (char c : words[index].toCharArray()) {
            if (freqCopy[c - 'a'] == 0) {
                scoreCopy = 0;
                break;
            } else {
                freqCopy[c - 'a']--;
                scoreCopy += score[c - 'a'];
            }
        }
        max = Math.max(max, scoreCopy + dfs(words, index + 1, freqCopy, score));
        max = Math.max(max, dfs(words, index + 1, freq, score));
        return max;
    }
}