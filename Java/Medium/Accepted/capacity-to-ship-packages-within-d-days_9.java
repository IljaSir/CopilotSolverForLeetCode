class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int min = 0;
        int max = 0;
        for(int weight: weights) {
            min = Math.max(min, weight);
            max += weight;
        }
        int result = max;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if (canShip(weights, days, mid)) {
                result = Math.min(result, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int count = 0;
        int sum = 0;
        for(int weight: weights) {
            if (sum + weight > capacity) {
                count++;
                sum = 0;
            }
            sum += weight;
        }
        return count < days;
    }
}