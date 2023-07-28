class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        char[] res = new char[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[lcp[i][j]]++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] == 0) {
                res[i] = 'a';
            } else {
                int j = 0;
                while (count[j] > 0) {
                    j++;
                }
                res[i] = (char) ('a' + j);
                count[j] = -1;
            }
        }
        return new String(res);
    }
}