class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = intervals[0][1];
        for rn count;
    }
}