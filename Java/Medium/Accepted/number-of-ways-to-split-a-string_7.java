class Solution {
    public int numWays(String s) {
        
        int n = s.length();
        int ones = 0;
        int mod = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        if (ones == 0) {
            return (int)(((long)(n - 2) * (n - 1) / 2) % mod);
        }
        if (ones % 3 != 0) {
            return 0;
        }
        int k = ones / 3;
        int cnt = 0;
        int first = 0;
        int second = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
            if (cnt == k) {
                first++;
            }
            if (cnt == 2 * k) {
                second++;
            }
        }
        return (int)(((long)first * second) % mod);
    }
}