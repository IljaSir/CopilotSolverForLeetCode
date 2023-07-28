class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 1;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int result = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canEatAll(piles, mid, h)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }
    
    private boolean canEatAll(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile - 1) / speed + 1;
        }
        return time <= h;
    }
}