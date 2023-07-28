class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        int ans = 0;
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            int j = i - 1;
            while (j >= 0 && intervals[j][1] == r) {
                l = Math.max(l, max[j]);
                j--;
            }
            if (l == r) {
                ans++;
                max[i] = r - 1;
            } else if (l == r - 1) {
                ans += 2;
                max[i] = r;
            } else {
                ans += 2;
                max[i] = r - 1;
            }
        }
        return ans;
    }
}