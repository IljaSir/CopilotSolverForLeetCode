class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if (m * k > bloomDay.length) return -1;
        int low = 1, high = 1000000000;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (canMake(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0, flowers = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}