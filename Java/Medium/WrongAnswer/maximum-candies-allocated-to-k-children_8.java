class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int n = candies.length;
        int ans = 0;
        long lo = 0;
        long hi = (long) 1e12;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += Math.min(mid, candies[i]);
            }
            if (cnt >= k) {
                ans = (int) mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}