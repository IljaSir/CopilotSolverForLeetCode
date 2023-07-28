class Solution {
    public int preimageSizeFZF(int k) {
        
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = count(mid);
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return count(lo) == k ? 5 : 0;
    }
    
    private long count(long x) {
        long cnt = 0;
        while (x > 0) {
            cnt += x / 5;
            x /= 5;
        }
        return cnt;
    }
}