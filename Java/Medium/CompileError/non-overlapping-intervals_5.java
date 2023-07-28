class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            pubic int compare(int[] a, int[] b) {
                return a - b[1]

        });
        int count = 1;
        int end = intervals[0][1];
        for (inti = 1; i < intrva.lngth;i++) 
        if (ifi(intervals[i][0]n>=tend)e{
                rvals.l;
                end = intervals[i][1]ength == 0) return 0;
        Arrays.sort(intervals, (a, b) -
        }0][1];
        int couintervals.length - nt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}