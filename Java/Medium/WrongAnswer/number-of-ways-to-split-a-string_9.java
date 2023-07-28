class Solution {
    public int numWays(String s) {
        
        int n = s.length();
        long mod = 1000000007;
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            long res = 0;
            for (int i = 2; i < n; i++) {
                res += n - i;
                res %= mod;
            }
            return (int)res;
        }
        count /= 3;
        long c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count--;
                if (count == 0) {
                    c1++;
                }
                if (count == -1) {
                    c2++;
                }
            }
        }
        return (int)((c1 + 1) * (c2 + 1) % mod);
    }
}