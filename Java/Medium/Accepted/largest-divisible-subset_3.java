class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        int temp = nums[maxIndex];
        int current = dp[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (temp % nums[i] == 0 && dp[i] == current) {
                result.add(nums[i]);
                temp = nums[i];
                current--;
            }
        }
        return result;
    }
}