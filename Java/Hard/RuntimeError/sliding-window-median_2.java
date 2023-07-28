class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        int n = nums.length - k + 1;
        double[] medians = new double[n];
        int[] window = new int[k];
        System.arraycopy(nums, 0, window, 0, k);
        Arrays.sort(window);
        for (int i = 0; i < n; i++) {
            medians[i] = k % 2 == 0 ? ((double) window[k / 2] + window[k / 2 - 1]) / 2 : window[k / 2];
            if (i == n - 1) {
                break;
            }
            int left = Arrays.binarySearch(window, nums[i]);
            int right = Arrays.binarySearch(window, nums[i + k]);
            if (left < right) {
                System.arraycopy(window, left + 1, window, left, right - left);
                window[right] = nums[i + k];
            } else {
                System.arraycopy(window, right + 1, window, right, left - right);
                window[left] = nums[i + k];
            }
        }
        return medians;
    }
}