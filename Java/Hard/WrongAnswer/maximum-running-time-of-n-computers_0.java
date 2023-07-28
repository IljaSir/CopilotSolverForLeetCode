class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long min = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            min += batteries[i];
            max += batteries[batteries.length - 1 - i];
        }
        while (min < max) {
            long mid = min + (max - min) / 2;
            long need = 0;
            for (int i = 0; i < n; i++) {
                need += mid - batteries[i];
            }
            if (need >= 0) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min - 1;
    }
}