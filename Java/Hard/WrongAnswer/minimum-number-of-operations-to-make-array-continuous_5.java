class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int ans = n;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] < n) {
                ++j;
            }
            ans = Math.min(ans, n - (j - i));
        }
        return ans;
    }
}