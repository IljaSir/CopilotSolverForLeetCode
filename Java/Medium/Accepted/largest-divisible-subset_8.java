class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        int i = maxIndex;
        while (i >= 0) {
            result.add(nums[i]);
            i = prev[i];
        }
        return result;
    }
}