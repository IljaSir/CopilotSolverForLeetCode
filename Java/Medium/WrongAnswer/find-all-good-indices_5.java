class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = nums[0];
        rightMin[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        for (int i = k; i < n - k; i++) {
            if (leftMax[i - 1] <= nums[i] && nums[i] <= rightMin[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }
}