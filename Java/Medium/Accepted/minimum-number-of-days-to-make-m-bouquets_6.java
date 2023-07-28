class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int left = 0, right = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            right = Math.max(right, bloomDay[i]);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canMake(bloomDay, m, k, left) ? left : -1;
    }
    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;
        for (int i = 0; i < bloomDay.length && bouquets < m; i++) {
            if (bloomDay[i] <= day) {
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