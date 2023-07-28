class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] newNums = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = newNums[n + 1] = 1;
        int[][] memo = new int[n + 2][n + 2];
        return burst(memo, newNums, 0, n + 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (memo[left][right] > 0) {
            return memo[left][right];
        }
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            int temp = nums[left] * nums[i] * nums[right];
            temp += burst(memo, nums, left, i);
            temp += burst(memo, nums, i, right);
            ans = Math.max(ans, temp);
        }
        memo[left][right] = ans;
        return ans;
    }
}