class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += batteries[i];
        }
        long max = sum / n;
        int i = 0;
        while (i < n && batteries[i] >= max) {
            i++;
        }
        if (i == n) {
            return max;
        }
        long min = max - 1;
        long mid;
        while (min < max) {
            mid = (max + min) / 2;
            if (check(mid, n, batteries)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min - 1;
    }
    
    public boolean check(long time, int n, int[] batteries) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(batteries[i], time);
        }
        return sum >= time * n;
    }
}