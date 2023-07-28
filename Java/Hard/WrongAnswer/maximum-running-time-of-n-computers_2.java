class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long lo = 1;
        long hi = 0;
        for (int i = 0; i < n; i++) {
            hi += batteries[i];
        }
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (canRun(n, batteries, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    private boolean canRun(int n, int[] batteries, long mid) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += batteries[i];
        }
        for (int i = n; i < batteries.length; i++) {
            sum += batteries[i];
            sum -= batteries[i - n];
            if (sum >= mid * n) {
                return true;
            }
        }
        return false;
    }
}