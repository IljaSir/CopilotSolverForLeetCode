class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int[] ans = new int[nums.length];
        int max = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int tmp = nums[i];
            ans[i] = max;
            max = Math.max(max, tmp);
        }
        return ans;
    }
}