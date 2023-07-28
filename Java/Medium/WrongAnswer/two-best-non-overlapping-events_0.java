class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int n = events.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = events[i][2];
        }
        for (int i = 1; i < n; i++) {
            int start = events[i][0];
            int end = events[i][1];
            int index = binarySearch(events, start);
            if (index >= 0) {
                dp[i] = Math.max(dp[i], events[i][2] + dp[index]);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    private int binarySearch(int[][] events, int target) {
        int left = 0;
        int right = events.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (events[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}