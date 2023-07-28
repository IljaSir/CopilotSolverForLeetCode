class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canEatAll(piles, h, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}