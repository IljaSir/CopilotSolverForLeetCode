class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int[] ans = new int[nums.length];
        int i = 0, j = 0;
        while (i < nums.length) {
            ans[i] = nums[j];
            i += 2;
            j++;
        }
        i = 1;
        while (i < nums.length) {
            ans[i] = nums[j];
            i += 2;
            j++;
        }
        return ans;
    }
}