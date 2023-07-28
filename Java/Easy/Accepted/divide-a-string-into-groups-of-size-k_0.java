class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = (n + k - 1) / k;
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            int l = i * k;
            int r = Math.min(n, l + k);
            ans[i] = s.substring(l, r);
            if (r - l < k) {
                ans[i] += String.valueOf(fill).repeat(k - r + l);
            }
        }
        return ans;
    }
}