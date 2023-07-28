class Solution {
    public int[] applyOperations(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                ans[j++] = nums[i] * 2;
                i++;
            } else {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}