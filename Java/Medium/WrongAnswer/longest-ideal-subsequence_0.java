class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) - s.charAt(i - 1) <= k) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 0;
            }
        }
        r[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i + 1) - s.charAt(i) <= k) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, l[i] + r[i] + 1);
        }
        return ans;
    }
}