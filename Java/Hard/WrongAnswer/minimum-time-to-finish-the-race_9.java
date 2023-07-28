class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int min = Integer.MAX_VALUE;
        for(int[] tire : tires){
            min = Math.min(min, tire[0] + tire[1] * (numLaps - 1));
        }
        int ans = Integer.MAX_VALUE;
        for(int[] tire : tires){
            ans = Math.min(ans, tire[0] * numLaps + tire[1] * (numLaps - 1) * (numLaps - 2) / 2 + (numLaps - 1) * changeTime);
        }
        return ans;
    }
}