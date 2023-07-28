class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int n = candies.length;
        int l = 0, r = 10000000;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += Math.min(candies[i], mid);
            }
            if (cnt > k) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}