class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int[] window = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(window);
            if (k % 2 == 1) {
                ans[i] = window[k / 2];
            } else {
                ans[i] = (window[k / 2 - 1] + window[k / 2]) / 2.0;
            }
        }
        return ans;
    }
}