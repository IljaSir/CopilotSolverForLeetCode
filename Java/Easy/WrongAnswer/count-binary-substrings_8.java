class Solution {
    public int countBinarySubstrings(String s) {
        
        int n = s.length();
        int[] count = new int[n];
        int cur = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(cur, count[i - 1]);
                cur = 0;
            }
            cur++;
            count[i] = cur;
        }
        return res + Math.min(cur, count[n - 1]);
    }
}