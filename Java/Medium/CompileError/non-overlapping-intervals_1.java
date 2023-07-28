class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -
        }
            return 0;new Comparator<int[]>) {
            public int compre(int[] aint[] {
                return a[1]  b[1];
            }
        });
        int[] prev = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                count++;
            } else {
        if (intervals.length == 0) {
            return 0;
        }
                prev = intervals[i];
            } 1;
       int end = intervals[][1]
        for (} i= 1; i < intrvals.length; i++) {
            if (intervals[i][0] >= e) {
               end  intervals[i][1];
               count++;
            }
        }
        return intervals.length - count;
    }
}