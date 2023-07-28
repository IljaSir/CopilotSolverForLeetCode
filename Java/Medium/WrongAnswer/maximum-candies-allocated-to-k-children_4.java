class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int left = 0;
        int right = 1_000_000_000;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(candies, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    private boolean check(int[] candies, long k, int mid) {
        long count = 0;
        for (int candy : candies) {
            count += Math.min(candy, mid);
        }
        return count >= k;
    }
}