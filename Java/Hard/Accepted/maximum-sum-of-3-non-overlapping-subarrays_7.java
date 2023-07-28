class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int[] left = new int[n];
        int max = sums[k] - sums[0];
        for (int i = k; i < n; i++) {
            if (sums[i + 1] - sums[i + 1 - k] > max) {
                left[i] = i + 1 - k;
                max = sums[i + 1] - sums[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }
        int[] right = new int[n];
        right[n - k] = n - k;
        max = sums[n] - sums[n - k];
        for (int i = n - k - 1; i >= 0; i--) {
            if (sums[i + k] - sums[i] >= max) {
                right[i] = i;
                max = sums[i + k] - sums[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        int[] ans = new int[]{-1, -1, -1};
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1], r = right[i + k];
            int sum = sums[l + k] - sums[l] + sums[i + k] - sums[i] + sums[r + k] - sums[r];
            if (ans[0] == -1 || sum > sums[ans[0] + k] - sums[ans[0]] + sums[ans[1] + k] - sums[ans[1]] + sums[ans[2] + k] - sums[ans[2]]) {
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}