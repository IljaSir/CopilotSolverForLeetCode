class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int count = 0;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                count++;
            }else{
                end = intervals[i][1]rvals, (a, b) -> a[1 - b)
        Arrays.nt = 1;
        iso endrt(intervals[0][i]ntervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] prev = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                count++;
            } else {
                prev = intervals[i];
            }
        }
        return count;
    }
}