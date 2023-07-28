class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[k] = k;
        for (int i = k - 1; i >= 0; i--) {
            left[i] = nums[i] > nums[left[i + 1]] ? left[i + 1] : i;
        }
        right[k] = k;
        for (int i = k + 1; i < n; i++) {
            right[i] = nums[i] > nums[right[i - 1]] ? right[i - 1] : i;
        }
        int ans = nums[k];
        for (int i = k; i >= 0; i--) {
            ans = Math.max(ans, nums[left[i]] * (right[i] - left[i] + 1));
            if (i == 0) {
                break;
            }
        }
        for (int i = k; i < n; i++) {
            ans = Math.max(ans, nums[right[i]] * (right[i] - left[i] + 1));
            if (i == n - 1) {
                break;
            }
        }
        return ans;
    }
}