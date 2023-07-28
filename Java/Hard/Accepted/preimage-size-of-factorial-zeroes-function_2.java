class Solution {
    public int preimageSizeFZF(int k) {
        
        long l = 0, r = Long.MAX_VALUE;
        while (l < r) {
            long m = l + (r - l) / 2;
            long z = zeta(m);
            if (z < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return zeta(l) == k ? 5 : 0;
    }
    
    long zeta(long x) {
        long res = 0;
        while (x > 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }
}