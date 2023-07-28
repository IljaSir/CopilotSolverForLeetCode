class Solution {
    public boolean isSolvable(String[] words, String result) {
        
        int n = words.length;
        int m = result.length();
        int[] wordValues = new int[n];
        int resultValue = 0;
        int[] charValues = new int[26];
        Arrays.fill(charValues, -1);
        int[] charUsed = new int[26];
        int[] charLength = new int[26];
        int[] charPosition = new int[26];
        int charCount = 0;
        int charIndex = 0;
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                char c = words[i].charAt(j);
                charValues[c-'A'] = 0;
                charLength[c-'A'] = len - j;
                charPosition[c-'A'] = i;
                charUsed[c-'A'] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            char c = result.charAt(i);
            charValues[c-'A'] = 0;
            charLength[c-'A'] = m - i;
            charPosition[c-'A'] = -1;
            charUsed[c-'A'] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if (charUsed[i] == 1) {
                charIndex = i;
                charCount++;
            }
        }
        if (charCount > 10) {
            return false;
        }
        return dfs(words, result, charValues, charLength, charPosition, charIndex, charCount, 0);
    }
}