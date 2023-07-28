class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
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