class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long l = 0;
        long r = 100000;
        while (l < r) {
            long mid = (l + r) / 2;
            long apples = 0;
            for (int i = 1; i <= mid; i++) {
                apples += 4 * (mid / i) * i;
            }
            if (apples < neededApples) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l * 8;
    }
}