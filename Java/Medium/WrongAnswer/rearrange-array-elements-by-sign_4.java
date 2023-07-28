class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = n - 1;
        Arrays.sort(nums);
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                ans[k] = nums[i++];
            } else {
                ans[k] = nums[j--];
            }
        }
        return ans;
    }
}