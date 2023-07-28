class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int currProfit = jobs[i][2];
            int prev = binarySearch(jobs, i);
            if (prev != -1) {
                currProfit += dp[prev];
            }
            dp[i] = Math.max(dp[i - 1], currProfit);
        }
        return dp[n - 1];
    }
    
    private int binarySearch(int[][] jobs, int curr) {
        int low = 0, high = curr - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][1] <= jobs[curr][0]) {
                if (jobs[mid + 1][1] <= jobs[curr][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}