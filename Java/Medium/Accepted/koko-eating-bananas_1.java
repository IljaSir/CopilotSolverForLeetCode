class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        int min = 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canEatAll(piles, mid, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    private boolean canEatAll(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile - 1) / k + 1;
        }
        return hours <= h;
    }
}