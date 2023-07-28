class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        int[] char2num = new int[26];
        int[] num2char = new int[10];
        int[] word2num = new int[words.length];
        int result2num = 0;
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        maxLen = Math.max(maxLen, result.length());
        for (int i = 0; i < 10; i++) {
            num2char[i] = -1;
        }
        for (int i = 0; i < 26; i++) {
            char2num[i] = -1;
        }
        for (int i = 0; i < words.length; i++) {
            word2num[i] = 0;
        }
        result2num = 0;
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i < words[j].length()) {
                    int c = words[j].charAt(words[j].length() - 1 - i) - 'A';
                    if (char2num[c] == -1) {
                        char2num[c] = 0;
                    }
                    word2num[j] *= 10;
                    word2num[j] += char2num[c];
                }
            }
            if (i < result.length()) {
                int c = result.charAt(result.length() - 1 - i) - 'A';
                if (char2num[c] == -1) {
                    char2num[c] = 0;
                }
                result2num *= 10;
                result2num += char2num[c];
            }
        }
        for (int i = 0; i < 10; i++) {
            num2char[i] = -1;
        }
        for (int i = 0; i < 26; i++) {
            char2num[i] = -1;
        }
        return dfs(char2num, num2char, word2num, result2num, 0, 0);
    }
}