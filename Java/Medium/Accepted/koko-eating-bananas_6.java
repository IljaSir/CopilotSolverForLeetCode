class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = 1000000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (!canFinish(piles, mid, h)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time <= h;
    }
}