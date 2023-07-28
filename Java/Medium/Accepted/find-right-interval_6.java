class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int n = intervals.length;
        int[][] start = new int[n][2];
        for (int i = 0; i < n; i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }
        Arrays.sort(start, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int m = l + r >> 1;
                if (start[m][0] >= intervals[i][1]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            ans[i] = start[l][0] >= intervals[i][1] ? start[l][1] : -1;
        }
        return ans;
    }
}