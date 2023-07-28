class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            return (n - 1L) * (n - 2L) / 2L % 1000000007;
        }
        int mod = 1000000007;
        int k = (int) (count / 3);
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                c1++;
                if (c1 == k) {
                    c2 = i + 1;
                    break;
                }
            }
        }
        for (int i = c2; i < n; i++) {
            if (s.charAt(i) == '1') {
                c3 = i + 1;
                break;
            }
        }
        long ans = 0;
        long p1 = 0;
        long p2 = 0;
        for (int i = c2; i < n; i++) {
            if (s.charAt(i) == '1') {
                p2++;
            } else {
                ans += p1 * p2;
                ans %= mod;
                p1++;
            }
        }
        return ans;
    }
}