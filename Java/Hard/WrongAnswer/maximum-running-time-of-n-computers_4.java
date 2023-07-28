class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += batteries[i];
        }
        long max = sum / n;
        if (sum % n != 0) {
            max++;
        }
        for (int i = n; i < batteries.length; i++) {
            sum += batteries[i];
            sum -= batteries[i - n];
            long currentMax = sum / n;
            if (sum % n != 0) {
                currentMax++;
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }
}