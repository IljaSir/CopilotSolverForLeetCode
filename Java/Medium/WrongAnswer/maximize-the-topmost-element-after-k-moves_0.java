class Solution {
    public int maximumTop(int[] nums, int k) {
        
        int n = nums.length;
        int[] max = new int[n];
        max[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i+1], nums[i]);
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int moves = k - (n - i - 1);
            if (moves < 0) continue;
            if (moves <= i) {
                ans = Math.max(ans, max[i - moves]);
            }
        }
        return ans;
    }
}