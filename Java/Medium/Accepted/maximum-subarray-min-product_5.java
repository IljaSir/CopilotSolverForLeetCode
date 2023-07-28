class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i;
            while (left[i] > 0 && nums[i] <= nums[left[i] - 1]) {
                left[i] = left[left[i] - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = i;
            while (right[i] < n - 1 && nums[i] <= nums[right[i] + 1]) {
                right[i] = right[right[i] + 1];
            }
        }

        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (sum[right[i]] - (left[i] == 0 ? 0 : sum[left[i] - 1])) * nums[i]);
        }

        return (int) (ans % 1000000007);
    }
}