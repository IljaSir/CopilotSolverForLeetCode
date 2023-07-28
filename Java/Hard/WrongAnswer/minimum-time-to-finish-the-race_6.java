class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int res = Integer.MAX_VALUE;
        for (int[] tire : tires) {
            int fi = tire[0];
            int ri = tire[1];
            int time = 0;
            for (int i = 1; i <= numLaps; i++) {
                time += fi * ri;
                ri *= ri;
            }
            res = Math.min(res, time);
        }
        return res;
    }
}