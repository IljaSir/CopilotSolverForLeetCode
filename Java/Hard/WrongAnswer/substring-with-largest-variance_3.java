class Solution {
    public int largestVariance(String s) {
        
        int n = s.length();
        int[][] count = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                count[i][j] = i > 0 ? count[i - 1][j] : 0;
            }
            count[i][s.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    int c = count[j][k] - (i > 0 ? count[i - 1][k] : 0);
                    max = Math.max(max, c);
                    min = Math.min(min, c);
                }
                res = Math.max(res, max - min);
            }
        }
        return res;
    }
}