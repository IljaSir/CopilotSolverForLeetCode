class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int res = 0;
        int[] last = {-1, -1};
        for (int i = n - 1; i >= 0; i--) {
            int[] it = intervals[i];
            if (it[1] <= last[1]) continue;
            if (it[1] == last[0] + 1) {
                res++;
                last[1] = last[0];
                last[0] = it[1];
                continue;
            }
            res += 2;
            last[1] = it[1] - 1;
            last[0] = it[1];
        }
        return res;
    }
}