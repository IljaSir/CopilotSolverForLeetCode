class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] freq = new int[26];
        for (char c : letters) {
            freq[c - 'a']++;
        }
        return dfs(words, freq, score, 0);
    }
    
    private int dfs(String[] words, int[] freq, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }
        int res = dfs(words, freq, score, idx + 1);
        int[] freqCopy = Arrays.copyOf(freq, freq.length);
        int scoreCopy = 0;
        for (char c : words[idx].toCharArray()) {
            if (freqCopy[c - 'a'] > 0) {
                freqCopy[c - 'a']--;
                scoreCopy += score[c - 'a'];
            } else {
                scoreCopy = -1;
                break;
            }
        }
        if (scoreCopy != -1) {
            res = Math.max(res, scoreCopy + dfs(words, freqCopy, score, idx + 1));
        }
        return res;
    }
}