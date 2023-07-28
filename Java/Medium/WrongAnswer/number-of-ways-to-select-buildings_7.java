class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        int[] ones = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ones[i + 1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        if (ones[n] % 3 != 0) {
            return 0;
        }
        if (ones[n] == 0) {
            return (long) (n - 1) * (n - 2) / 2 % 1000000007;
        }
        int k = ones[n] / 3;
        int i1 = 0, i2 = 0, i3 = 0;
        for (int i = 0; i <= n; i++) {
            if (ones[i] == k) {
                i1 = i;
            } else if (ones[i] == 2 * k) {
                i2 = i;
            } else if (ones[i] == 3 * k) {
                i3 = i;
            }
        }
        return (long) (i2 - i1) * (i3 - i2) % 1000000007;
    }
}