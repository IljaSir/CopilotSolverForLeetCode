class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n = intervals.length;
        int[][] res = new int[n + 1][2];
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res[i] = intervals[i];
            i++;
        }
        int[] merged = newInterval;
        while (i < n && intervals[i][0] <= newInterval[1]) {
            merged = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            i++;
        }
        res[i] = merged;
        while (i < n) {
            res[i + 1] = intervals[i];
            i++;
        }
        return Arrays.copyOf(res, i + 1);
    }
}