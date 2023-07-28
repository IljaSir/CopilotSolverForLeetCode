class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length;
        int[] temp = new int[n];
        temp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            temp[i] = temp[i - 1] + nums[i];
        }
        double max = temp[k - 1] * 1.0 / k;
        for (int i = k; i < n; i++) {
            max = Math.max(max, (temp[i] - temp[i - k]) * 1.0 / k);
        }
        return max;
    }
}