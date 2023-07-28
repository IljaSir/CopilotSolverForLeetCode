class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int mod = 1000000007;
        long sum = 0;
        long max = 0;
        long minSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        if (k == 1) {
            return (int) (max % mod);
        }
        long totalSum = sum;
        long max2 = 0;
        sum = 0;
        minSum = 0;
        for (int i = 0; i < arr.length * 2; i++) {
            sum += arr[i % arr.length];
            max2 = Math.max(max2, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        if (totalSum > 0) {
            return (int) (Math.max(max, (max2 + (k - 2) * totalSum) % mod) % mod);
        } else {
            return (int) (Math.max(max, max2) % mod);
        }
    }
}