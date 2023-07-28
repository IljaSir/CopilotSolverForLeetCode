class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int lo = 1;
        int hi = 1000000000;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (canEatAllBananas(piles, h, mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }
    private boolean canEatAllBananas(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time += timeOfEatingBananas(pile, k);
        }
        return time <= h;
    }
}