class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
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
        int need = 1;
        int cur = 0;
        for (int weight : weights) {
            if (cur + weight > capacity) {
                need++;
                cur = 0;
            }
            cur += weight;
        }
        return need <= days;
    }
}