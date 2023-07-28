class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            l = Math.min(l, bloomDay[i]);
            r = Math.max(r, bloomDay[i]);
        }
        while (l < r) {
            int mid = (l + r) / 2;
            if (canMake(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean canMake(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
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