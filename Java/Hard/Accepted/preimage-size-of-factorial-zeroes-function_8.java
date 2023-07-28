class Solution {
    public int preimageSizeFZF(int k) {
        
        long lo = 0, hi = Long.MAX_VALUE;
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = trailingZeroes(mid);
            if(count == k) return 5;
            else if(count > k) hi = mid;
            else lo = mid + 1;
        }
        return 0;
    }
    private long trailingZeroes(long n) {
        long count = 0;
        for(long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
}