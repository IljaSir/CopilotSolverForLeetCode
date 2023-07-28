class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = 1000000007;
        long n = (1L << p) - 1;
        long ans = (n - 1) % mod;
        long a = n / 2;
        long b = n - a;
        ans = ans * pow(a, b, mod) % mod;
        return (int)ans;
    }

    long pow(long a, long b, long mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return ans;
    }
}
    }
}