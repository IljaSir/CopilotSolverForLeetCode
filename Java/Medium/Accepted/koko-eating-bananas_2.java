class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int i = 0; i < n; i++) {
                hours += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    hours++;
                }
            }
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}