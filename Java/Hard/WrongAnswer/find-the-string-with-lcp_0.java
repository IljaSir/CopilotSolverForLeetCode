class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        char[] res = new char[n];
        res[0] = 'a';
        for (int i = 1; i < n; i++) {
            res[i] = (char) (res[i - 1] + lcp[i - 1][i]);
        }
        return new String(res);
    }
}