class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int[] left = new int[nums.length];
        int maxSum = sums[k] - sums[0];
        for (int i = k, best = 0; i < nums.length; i++) {
            if (sums[i + 1] - sums[i + 1 - k] > maxSum) {
                best = i + 1 - k;
                maxSum = sums[i + 1] - sums[i + 1 - k];
            }
            left[i] = best;
        }
        int[] right = new int[nums.length];
        maxSum = sums[nums.length] - sums[nums.length - k];
        for (int i = nums.length - k - 1, best = nums.length - k; i >= 0; i--) {
            if (sums[i + k] - sums[i] >= maxSum) {
                best = i;
                maxSum = sums[i + k] - sums[i];
            }
            right[i] = best;
        }
        int[] ans = new int[]{-1, -1, -1};
        for (int j = k; j < nums.length - k; j++) {
            int l = left[j - 1], r = right[j + k];
            int total = (sums[l + k] - sums[l]) + (sums[j + k] - sums[j]) + (sums[r + k] - sums[r]);
            if (ans[0] == -1 || total > sums[ans[0] + k] - sums[ans[0]] + sums[ans[1] + k] - sums[ans[1]] + sums[ans[2] + k] - sums[ans[2]]) {
                ans[0] = l;
                ans[1] = j;
                ans[2] = r;
            }
        }
        return ans;
    }
}