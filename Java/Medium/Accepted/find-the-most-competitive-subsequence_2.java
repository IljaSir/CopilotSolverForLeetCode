class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int n = nums.length;
        int[] ans = new int[k];
        int top = 0;
        for (int i = 0; i < n; i++) {
            while (top > 0 && ans[top - 1] > nums[i] && top - 1 + n - i >= k) {
                top--;
            }
            if (top < k) {
                ans[top++] = nums[i];
            }
        }
        return ans;
    }
}