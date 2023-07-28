class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] - target[i]);
        }
        return count;
    }
    public int minOperations(int[] nums, int[] target) {
        long sum = makeSimilar(nums, target);
        if (sum == 0) {
            return 0;
        }
        if (sum % 2 != 0) {
            return -1;
        }
        sum /= 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            if (map.containsKey(target[i])) {
                numsList.add(map.get(target[i]));
            }
        }
        int[] numsArr = new int[numsList.size()];
        for (int i = 0; i < numsArr.length; i++) {
            numsArr[i] = numsList.get(i);
        }
        int n = numsArr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (numsArr[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][j - numsArr[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum] == Integer.MAX_VALUE ? -1 : dp[n][sum];
    }
}