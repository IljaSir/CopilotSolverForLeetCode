class Solution {
    public int[] recoverArray(int[] nums) {
        
        int n = nums.length / 2;
        int[] ans = new int[n];
        int[] diff = new int[n];
        int[] sum = new int[n];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            diff[i] = nums[i + n] - nums[i];
            sum[i] = nums[i + n] + nums[i];
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += diff[i];
        }
        k /= n;
        ans[0] = sum[0] / 2;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + k;
        }
        return ans;
    }
}