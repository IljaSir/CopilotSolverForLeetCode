class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        if (n <= 1) return 0;
        Arrays.sort(nums);
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                left[i] = left[i - 1];
            } else {
                left[i] = left[i - 1] + 1;
            }
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                right[i] = right[i + 1];
            } else {
                right[i] = right[i + 1] + 1;
            }
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            int l = i - left[i] + 1;
            int r = i + right[i] - 1;
            if (l < 0 || r >= n) continue;
            if (nums[r] - nums[l] + 1 == right[i] + left[i] - 1) {
                res = Math.min(res, n - (right[i] + left[i] - 1));
            }
        }
        return res;
    }
}