class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int len = piles.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, piles[i]);
        }
        int min = 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canFinish(piles, h, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    
    public boolean canFinish(int[] piles, int h, int speed) {
        int len = piles.length;
        int time = 0;
        for (int i = 0; i < len; i++) {
            time += piles[i] / speed;
            if (piles[i] % speed != 0) {
                time += 1;
            }
        }
        return time <= h;
    }
}