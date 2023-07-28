class Solution {
    public int numTimesAllBlue(int[] flips) {
        
        int on = 0, ans = 0;
        for (int i = 0; i < flips.length; ++i) {
            on += 1;
            if (on == flips[i]) {
                while (i + 1 < flips.length && flips[i + 1] == flips[i] + 1) {
                    ++i;
                }
                ++ans;
            }
        }
        return ans;
    }
}