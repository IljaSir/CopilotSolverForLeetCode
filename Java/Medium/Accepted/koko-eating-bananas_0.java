class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
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
    
    private boolean canFinish(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time += pile / k;
            if (pile % k != 0) {
                time++;
            }
        }
        return time <= h;
    }
}