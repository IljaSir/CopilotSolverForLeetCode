class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            r += batteries[i];
        }
        long res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(n, batteries, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
    private boolean check(int n, int[] batteries, long mid) {
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