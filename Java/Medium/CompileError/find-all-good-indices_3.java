class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i < k) {
                left[i] = Math.max(nums[i], left[i - 1]);
            } else {
                left[i] = left[i - 1];
            }
            int j = n - i - 1;
            if (j >= n - k) {
                right[j] = Math.min(nums[j], right[j + 1]);
            } else {
                right[j] = right[j + 1];
            }
        }
        for (int i = k; i < n - k; i++) {
            if (nums[i] >= left[i - 1] && nums[i] <= right[i + 1]) {
                ans.add(i);
            }
        }
        return result;
    }
}