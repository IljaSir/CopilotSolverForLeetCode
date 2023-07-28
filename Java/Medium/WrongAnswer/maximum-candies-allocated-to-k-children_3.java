class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        long left = 0, right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            for (int candy : candies) {
                count += Math.min(candy, mid);
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
}