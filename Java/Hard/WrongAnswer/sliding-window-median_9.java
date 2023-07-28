class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        
        // 1. get the median of the first window
        // 2. move the window to the right and get the median of the new window
        // 3. repeat step 2 until the end of the array
        // 4. return the result
        double[] result = new double[nums.length - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        result[0] = getMedian(window);
        for (int i = 1; i < nums.length - k + 1; i++) {
            // remove the first element of the window
            // add the new element at the end of the window
            // get the median of the new window
            window[0] = window[1];
            window[1] = window[2];
            window[2] = nums[i + 2];
            result[i] = getMedian(window);
        }
        return result;
    }
    
    private double getMedian(int[] window) {
        Arrays.sort(window);
        if (window.length % 2 == 0) {
            return (window[window.length / 2 - 1] + window[window.length / 2]) / 2.0;
        } else {
            return window[window.length / 2];
        }
    }
}