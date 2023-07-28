class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        List<Integr> res = ne
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (left[i - 1] <= nums[i] && nums[i] <= right[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }
}