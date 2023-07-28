class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        int left = 0, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(candies, k, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private boolean isPossible(int[] candies, long k, int target) {
        long count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += Math.min(candies[i], target);
        }
        return count >= k;
    }
}