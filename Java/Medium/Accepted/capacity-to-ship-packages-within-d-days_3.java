class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum = 0;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) {
                return false;
            }
            if (sum + weights[i] > capacity) {
                count++;
                sum = 0;
            }
            sum += weights[i];
        }
        return count + 1 <= days;
    }
}