class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int ans = 0;
        int[] last = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int l = intervals[i][0], r = intervals[i][1];
            if (last[0] < l || last[1] < l) {
                ans += 2;
                last[0] = r - 1;
                last[1] = r;
            } else if (last[1] < r) {
                ans++;
                last[0] = last[1];
                last[1] = r;
            }
        }
        return ans;
    }
}