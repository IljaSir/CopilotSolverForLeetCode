class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        while (i < intervals.length - 1) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = intervals[i][1];
                intervals[i][0] = -1;
                intervals[i][1] = -1;
            }
            i++;
        }
        return Arrays.stream(intervals).filter(a -> a[0] != -1).toArray(int[][]::new);
    }
}