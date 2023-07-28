class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];
        int[] durations = {1, 7, 30};
        for (int i = 0; i < days.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                int index = findIndex(days, days[i] - durations[j]);
                int cost = j == 0 ? costs[j] : costs[j] + dp[index];
                dp[i] = Math.min(dp[i], cost);
            }
        }
        return dp[days.length - 1];
    }

    private int findIndex(int[] days, int val) {
        int left = 0, right = days.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (days[mid] == val) {
                return mid;
            } else if (days[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}