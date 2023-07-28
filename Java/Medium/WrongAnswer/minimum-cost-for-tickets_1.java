class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < 3; j++) {
                int prev = findPrev(days, days[i] - (j == 0 ? 1 : j == 1 ? 7 : 30));
                if (prev == -1) {
                    dp[i] = Math.min(dp[i], costs[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[prev] + costs[j]);
                }
            }
        }
        return dp[dp.length - 1];
    }
    
    private int findPrev(int[] days, int target) {
        int left = 0;
        int right = days.length - 1;
        if (days[left] >= target) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (days[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}