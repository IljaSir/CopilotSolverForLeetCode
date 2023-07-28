class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        if (intervals.length == 1) {
            return 1;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            }
        });
        int count = 1;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= left && intervals[i][1] >= right) {
                left = intervals[i][0];
                right = intervals[i][1];
            } else if (intervals[i][0] >= left && intervals[i][1] <= right) {
                continue;
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}