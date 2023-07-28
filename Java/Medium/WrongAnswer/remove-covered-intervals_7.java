class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0, right = 0;
        for (int[] interval : intervals) {
            if (interval[1] > right) {
                right = interval[1];
                res++;
            }
        }
        return res;
    }
}