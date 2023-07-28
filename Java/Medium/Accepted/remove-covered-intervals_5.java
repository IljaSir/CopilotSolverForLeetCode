class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            boolean isCovered = false;
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) continue;
                if (intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
                    isCovered = true;
                    break;
                }
            }
            if (!isCovered) count++;
        }
        return count;
    }
}