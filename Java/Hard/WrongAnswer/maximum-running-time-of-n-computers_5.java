class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long l = 0, r = 0, mid;
        for (int i = 0; i < n; i++) {
            r += batteries[i];
        }
        while (l < r) {
            mid = (l + r + 1) >> 1;
            if (check(batteries, mid, n)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    boolean check(int[] batteries, long mid, int n) {
        int i = 0;
        while (i < n && mid >= batteries[i]) {
            mid -= batteries[i];
            i++;
        }
        if (i == n) {
            return true;
        }
        int j = batteries.length - 1;
        while (j >= i && mid >= batteries[j]) {
            mid -= batteries[j];
            j--;
        }
        return j == i - 1;
    }
}