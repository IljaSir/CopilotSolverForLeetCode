class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1, r = 1000000000;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (canFinish(piles, m, h)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean canFinish(int[] piles, int k, int h) {
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