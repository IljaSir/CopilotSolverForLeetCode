class Solution {
    public int minimumDeletions(int[] nums) {
        
        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];
        leftMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        int ans = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ans = Math.min(ans, nums.length - 1 - i - (rightMax[i + 1] == nums[i] ? 1 : 0));
            } else if (i == nums.length - 1) {
                ans = Math.min(ans, i - (leftMin[i - 1] == nums[i] ? 1 : 0));
            } else {
                ans = Math.min(ans, i - (leftMin[i - 1] == nums[i] ? 1 : 0) + nums.length - 1 - i - (rightMax[i + 1] == nums[i] ? 1 : 0));
            }
        }
        return ans;
    }
}