class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        for (int i = k; i < n - k; i++) {
            if (nums[i] > max[i - k] && nums[i] < min[i + k]) {
                result.add(i);
            }
        }
        return result;
    }
}