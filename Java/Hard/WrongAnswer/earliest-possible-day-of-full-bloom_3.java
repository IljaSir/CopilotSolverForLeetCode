class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = plantTime[i];
            times[i][1] = growTime[i];
        }
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, times[i][0] + times[i][1]);
            if (i < n - 1) {
                times[i + 1][0] = Math.max(times[i + 1][0], max);
            }
        }
        return max;
    }
}