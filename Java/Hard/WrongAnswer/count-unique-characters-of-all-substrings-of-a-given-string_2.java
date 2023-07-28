class Solution {
    public int uniqueLetterString(String s) {
        
        int[][] prev = new int[s.length()][26];
        int[][] next = new int[s.length()][26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                prev[i][j] = -1;
                next[i][j] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (j == c - 'A') {
                    prev[i][j] = i;
                } else {
                    prev[i][j] = i == 0 ? -1 : prev[i - 1][j];
                }
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (j == c - 'A') {
                    next[i][j] = i;
                } else {
                    next[i][j] = i == s.length() - 1 ? -1 : next[i + 1][j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int left = i - prev[i][c - 'A'];
            int right = next[i][c - 'A'] == -1 ? s.length() - i : next[i][c - 'A'] - i;
            ans += left * right;
        }
        return ans;
    }
}