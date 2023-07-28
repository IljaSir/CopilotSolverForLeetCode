class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 1;
        int max = 0;
        int mid = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        while (min < max) {
            mid = min + (max - min) / 2;
            if (canFinish(piles, h, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] - 1) / k + 1;
        }
        return time <= h;
    }
}