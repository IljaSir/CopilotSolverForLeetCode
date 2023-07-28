class Solution {
    public int minImpossibleOR(int[] nums) {
        
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length && ans >= nums[i]; i++) {
            ans += nums[i];
        }
        return ans;
    }
}