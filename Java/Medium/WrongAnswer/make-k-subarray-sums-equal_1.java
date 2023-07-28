class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % k != 0) {
            return -1;
        }
        long target = sum / k;
        long[] diffs = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            diffs[i] = arr[i] - target;
        }
        long[] prefixSums = new long[arr.length];
        prefixSums[0] = diffs[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + diffs[i];
        }
        long minOperations = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long targetPrefixSum = i == 0 ? 0 : prefixSums[i - 1];
            int left = i;
            int right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                long prefixSum = prefixSums[mid] - targetPrefixSum;
                if (prefixSum == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            long prefixSum = prefixSums[left] - targetPrefixSum;
            if (prefixSum == 0) {
                long operations = 0;
                for (int j = i; j <= left; j++) {
                    operations += Math.abs(diffs[j]);
                }
                minOperations = Math.min(minOperations, operations);
            }
        }
        return minOperations;
    }
}