class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (nums[i] % 2 == 0) {
                    ans++;
                }
            } else {
                if (nums[i] % 2 == 1) {
                    ans++;
                }
            }
        }
        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (nums[i] % 2 == 1) {
                    ans2++;
                }
            } else {
                if (nums[i] % 2 == 0) {
                    ans2++;
                }
            }
        }
        return Math.min(ans, ans2);
    }
}