class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            int[] prev = points[i - 1];
            int[] curr = points[i];
            int x = Math.abs(prev[0] - curr[0]);
            int y = Math.abs(prev[1] - curr[1]);
            time += Math.max(x, y);
        }
        return time;
    }
}