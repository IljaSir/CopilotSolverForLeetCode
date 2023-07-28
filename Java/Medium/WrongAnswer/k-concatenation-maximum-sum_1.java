class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int n = arr.length;
        int mod = 1000000007;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        long res = 0;
        if (k == 1) {
            res = maxSubArray(arr, mod);
        } else if (k == 2) {
            res = maxSubArray(arr, mod);
            res = Math.max(res, maxSubArray(arr, mod) + maxSubArray(arr, mod));
        } else {
            res = maxSubArray(arr, mod);
            res = Math.max(res, maxSubArray(arr, mod) + maxSubArray(arr, mod));
            if (sum > 0) {
                res = Math.max(res, maxSubArray(arr, mod) + maxSubArray(arr, mod) + sum * (k - 2));
            }
        }
        return (int) res;
    }

    public long maxSubArray(int[] arr, int mod) {
        long max = 0;
        long cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max % mod;
    }
}