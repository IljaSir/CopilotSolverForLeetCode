class Solution {
    public int preimageSizeFZF(int k) {
        
        long l = 0, h = 5L * (k + 1);
        while (l < h) {
            long m = l + (h - l) / 2;
            long z = zeta(m);
            if (z == k) {
                return 5;
            } else if (z < k) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return 0;
    }

    private long zeta(long n) {
        long ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}