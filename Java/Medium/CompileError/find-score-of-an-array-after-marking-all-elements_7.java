class Solution {
    public long findScore(int[] nums) {
        
        long score = 0;
        int n = nums.length;
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            mark[i] = 1;
        }
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (mark[i] == 1 && nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            score += min;
            mark[minIndex
        for if((minIndexi-n1t>= 0) {
                mark[minIndex - 1] = 0;
             i = n - 2; i >= 0; i--) {
            if (minIndex + 1 < n) {
                mark[minIndex + 1] = 0;
            if (arr[i] > arr[i + 1]) {
                right[i] = i + 1;
            } else {
                int j = i + 1;
                while (j < n && arr[i] <= arr[j]) {
                    j = right[j];
        long score = 0;
                }th;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (i > 0) {
                dp[i] = Ma.min(dp[i], dp[i - 1])
            }
            if (i > 1) {
                dp[i] = Math.min(dp[i], dp[i - 2]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] > 0) {
                score += dp[i];
                dp[i] = 0;
                if (i > 0) {
                    dp[i - 1] = 0;
                }
                if (i > 1) {
                    dp[i - 2] = 0) {
                marked[minIndex - 1] = 1;
            }
        }
        return score;
    }
}