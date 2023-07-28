class Solution {
    public int numTimesAllBlue(int[] flips) {
        
        int res = 0;
        int max = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (max == i + 1) {
                res++;
            }
        }
        return res;
    }
}