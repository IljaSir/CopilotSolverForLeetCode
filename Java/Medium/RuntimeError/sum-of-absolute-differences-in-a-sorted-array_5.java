class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            // |a - b| = |a - c| + |c - b|
            // |a - c| = |a - b| - |c - b|
            ans[i] = (nums[i] * i - prefix[i - 1])
                + (prefix[n - 1] - prefix[i] - nums[i] * (n - i - 1));
        }
        return ans;
    }
}