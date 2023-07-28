class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long[] mins = new long[n];
        long[] maxs = new long[n];
        for (int i = 0; i < n; i++) {
            mins[i] = batteries[i];
            maxs[i] = batteries[i];
        }
        for (int i = n; i < batteries.length; i++) {
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, mins[j]);
                max = Math.max(max, maxs[j]);
            }
            mins[i % n] = min + batteries[i];
            maxs[i % n] = max + batteries[i];
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, mins[j]);
            max = Math.max(max, maxs[j]);
        }
        return max;
    }
}