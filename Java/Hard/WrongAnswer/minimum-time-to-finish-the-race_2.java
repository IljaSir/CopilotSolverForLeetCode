class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length;
        int[] times = new int[n];
        for(int i = 0; i < n; i++) {
            int f = tires[i][0];
            int r = tires[i][1];
            int time = 0;
            for(int j = 1; j <= numLaps; j++) {
                time += f * (int)Math.pow(r, j-1);
            }
            times[i] = time;
        }
        Arrays.sort(times);
        return times[0] + (numLaps-1) * changeTime;
    }
}