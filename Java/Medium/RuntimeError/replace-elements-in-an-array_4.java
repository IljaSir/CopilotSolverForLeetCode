class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int n = nums.length;
        int m = operations.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        for (int i = 0; i < m; i++) {
            int index = operations[i][0] - 1;
            int value = operations[i][1];
            ans[index] = value;
        }
        return ans;
    }
}