class Solution {
    public int minOperations(int[] nums) {
        
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1];
        int min = nums[0];
        int res = n - 1;
        for (int i = 0; i < n; i++) {
            int j = Math.min(n - 1, i + res);
            if (nums[j] - nums[i] < n) {
                res = Math.min(res, n - (j - i + 1));
            }
        }
        return res;
    }
}