class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long left = 0;
        long right = 100000;
        while (left < right) {
            long mid = (left + right) / 2;
            long apples = (mid + 1) * (mid + 1) * (mid + 1) - mid * mid * mid;
            if (apples >= neededApples) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * 8;
    }
}