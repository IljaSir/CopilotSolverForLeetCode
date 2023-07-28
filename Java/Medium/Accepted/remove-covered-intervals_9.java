class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int count = 0;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int[] a = intervals[i];
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] b = intervals[j];
                if (b[0] <= a[0] && a[1] <= b[1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}