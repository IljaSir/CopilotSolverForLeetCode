class Solution {
    public int makeStringSorted(String s) {
        
        int MOD = (int)1e9 + 7;
        int n = s.length();
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            f[s.charAt(i) - 'a']++;
        }
        long res = 0;
        long fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i % MOD;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.charAt(i) - 'a'; j++) {
                if (f[j] > 0) {
                    f[j]--;
                    res = (res + fact) % MOD;
                    f[j]++;
                }
            }
            fact = fact * inv(n - i, MOD) % MOD;
            f[s.charAt(i) - 'a']--;
        }
        return (int)res;
    }

    public long inv(long x, int MOD) {
        return pow(x, MOD - 2, MOD);
    }

    public long pow(long a, long n, int MOD) {
        // return a ^ n % MOD
        long ret = 1;
        int x = 63 - Long.numberOfLeadingZeros(n);
        for (; x >= 0; x--) {
            ret = ret * ret % MOD;
            if (n << 63 - x < 0) {
                ret = ret * a % MOD;
            }
        }
        return ret;
    }
}