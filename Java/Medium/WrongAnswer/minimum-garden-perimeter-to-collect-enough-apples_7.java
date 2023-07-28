class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long left = 0;
        long right = 1000000;
        while (left < right) {
            long mid = (left + right) / 2;
            long apples = (4 * mid * mid + 4 * mid + 1) * (mid + 1) / 2;
            if (apples >= neededApples) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return 8 * left;
    }
}