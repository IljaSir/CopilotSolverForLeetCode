class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int[] res = new int[k];
        int n = nums.length;
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && nums[i] < res[top] && n - i + top >= k) {
                top--;
            }
            if (top < k - 1) {
                res[++top] = nums[i];
            }
        }
        return res;
    }
}