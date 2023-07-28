class Solution {
    public int distinctAverages(int[] nums) {
        
        // 2 <= nums.length <= 100
        // nums.length is even.
        // 0 <= nums[i] <= 100
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                set.add((preSum[j + 1] - preSum[i]) * 1.0 / (j - i));
            }
        }
        return set.size();
    }
}