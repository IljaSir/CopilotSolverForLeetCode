class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        int max = dp[0];
        int prev = 0;
        for (int i = 1; i < n; i++) {
            int[] event = events[i];
            int start = event[0];
            int end = event[1];
            int value = event[2];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (events[mid][1] < start) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (events[left][1] < start) {
                prev = left;
            } else {
                prev = -1;
            }
            dp[i] = Math.max(dp[i - 1], value + (prev < 0 ? 0 : dp[prev]));
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}