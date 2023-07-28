class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        return mergeSort(preSum, 0, n + 1, lower, upper);
    }
    private int mergeSort(long[] preSum, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = mergeSort(preSum, start, mid, lower, upper) + mergeSort(preSum, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (k < end && preSum[k] - preSum[i] < lower) {
                k++;
            }
            while (j < end && preSum[j] - preSum[i] <= upper) {
                j++;
            }
            while (t < end && preSum[t] < preSum[i]) {
                cache[r++] = preSum[t++];
            }
            cache[r] = preSum[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, preSum, start, t - start);
        return count;
    }
}