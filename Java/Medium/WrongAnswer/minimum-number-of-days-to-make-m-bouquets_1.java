class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] > days) {
                flowers = 0;
            } else {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            }
        }
        return bouquets >= m;
    }
}