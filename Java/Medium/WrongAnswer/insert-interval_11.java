class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] ans = new int[intervals.length + 1][2];
        int i = 0;
        int j = 0;
        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0]) {
                ans[j] = intervals[i];
                j++;
            } else if (intervals[i][0] > newInterval[1]) {
                ans[j] = newInterval;
                j++;
                while (i < intervals.length) {
                    ans[j] = intervals[i];
                    j++;
                    i++;
                }
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
            i++;
        }
        if (j < ans.length) {
            ans[j] = newInterval;
        }
        return Arrays.copyOf(ans, j + 1);
    }
}