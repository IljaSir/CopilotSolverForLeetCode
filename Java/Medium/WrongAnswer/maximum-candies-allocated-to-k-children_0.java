class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        int left = 0, right = max;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(candies, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] candies, int mid, long k) {
        long res = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > mid) {
                res += (candies[i] - mid) / (mid + 1);
                if ((candies[i] - mid) % (mid + 1) > 0) {
                    res++;
                }
            }
        }
        return res <= k;
    }
}