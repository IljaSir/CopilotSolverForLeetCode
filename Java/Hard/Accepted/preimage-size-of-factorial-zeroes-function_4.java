class Solution {
    public int preimageSizeFZF(int k) {
        
        long l = 0, r = Long.MAX_VALUE;
        while (l < r) {
            long m = l + (r - l) / 2;
            long c = trailingZeroes(m);
            if (c == k) {
                return 5;
            } else if (c < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return 0;
    }
    
    private long trailingZeroes(long n) {
        long c = 0;
        while (n > 0) {
            n /= 5;
            c += n;
        }
        return c;
    }
}