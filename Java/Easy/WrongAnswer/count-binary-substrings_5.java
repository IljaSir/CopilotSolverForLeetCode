class Solution {
    public int countBinarySubstrings(String s) {
        
        int n = s.length();
        int[] count = new int[n];
        int t = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                t = 0;
            }
            count[t]++;
            t++;
        }
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            ans += Math.min(count[i], count[i - 1]);
        }
        return ans;
    }
}