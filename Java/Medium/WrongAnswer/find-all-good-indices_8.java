class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i + 1]);
        }
        for (int i = k; i < n - k; i++) {
            if (left[i] < nums[i] && nums[i] < right[i]) {
                res.add(i);
            }
        }
        return res;
    }
}