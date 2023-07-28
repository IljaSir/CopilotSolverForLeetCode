class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int m = n - k + 1;
        double[] ans = new double[m];
        int[] window = new int[k];
        System.arraycopy(nums, 0, window, 0, k);
        Arrays.sort(window);
        for (int i = k; i <= n; i++) {
            if (k % 2 == 0) {
                ans[i - k] = ((double) window[k / 2 - 1] + window[k / 2]) / 2;
            } else {
                ans[i - k] = window[k / 2];
            }
            if (i == n) {
                break;
            }
            // remove nums[i - k]
            int j = Arrays.binarySearch(window, nums[i - k]);
            System.arraycopy(window, j + 1, window, j, k - j - 1);
            // add nums[i]
            j = Arrays.binarySearch(window, nums[i]);
            if (j < 0) {
                j = -j - 1;
            }
            System.arraycopy(window, j, window, j + 1, k - j - 1);
            window[j] = nums[i];
        }
        return ans;
    }
}