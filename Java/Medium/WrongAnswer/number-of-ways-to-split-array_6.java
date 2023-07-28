class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            int min = i + 1;
            int max = n - 1;
            while (min < max) {
                int mid = min + (max - min) / 2;
                int sum1 = prefixSum[i];
                int sum2 = prefixSum[mid] - prefixSum[i];
                int sum3 = prefixSum[n - 1] - prefixSum[mid];
                if (sum1 <= sum2 && sum2 <= sum3) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            if (min == max) {
                int sum1 = prefixSum[i];
                int sum2 = prefixSum[min] - prefixSum[i];
                int sum3 = prefixSum[n - 1] - prefixSum[min];
                if (sum1 <= sum2 && sum2 <= sum3) {
                    res = (res + (n - min)) % 1000000007;
                }
            }
        }
        return res;
    }
}