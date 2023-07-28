class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;
        if (m * k > n) return -1;
        int l = 1, r = 1;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, bloomDay[i]);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            int bouquets = 0, flowers = 0;
            for (int i = 0; i < n && bouquets < m; i++) {
                if (bloomDay[i] <= mid) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}