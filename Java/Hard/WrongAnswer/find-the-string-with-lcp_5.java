class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        char[] word = new char[n];
        for (int i = 0; i < n; ++i) {
            word[i] = 'a';
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (lcp[i][j] + i == j) {
                    word[i] = (char) (word[j] + 1);
                } else if (lcp[i][j] + i > j) {
                    word[i] = (char) Math.min(word[i], word[j]);
                }
            }
        }
        int i = 0;
        while (i < n && word[i] == 'a') {
            ++i;
        }
        return i == n ? "" : new String(word, i, n - i);
    }
}