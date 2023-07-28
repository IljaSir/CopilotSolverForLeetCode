class Solution {
    public int preimageSizeFZF(int k) {
        
        long l = 0, r = Long.MAX_VALUE;
        while (l < r) {
            long m = l + (r - l) / 2;
            long z = zeta(m);
            if (z == k) {
                return 5;
            } else if (z < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return 0;
    }
    
    private long zeta(long x) {
        long ans = 0;
        while (x > 0) {
            ans += x / 5;
            x /= 5;
        }
        return ans;
    }
}