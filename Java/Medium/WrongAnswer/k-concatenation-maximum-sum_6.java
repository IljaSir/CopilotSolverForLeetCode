class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        long max = 0;
        long sum = 0;
        long maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            maxSum = Math.max(maxSum, sum);
        }
        if (k > 1) {
            long sum2 = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                sum2 += arr[i];
                maxSum = Math.max(maxSum, sum2);
            }
            maxSum = Math.max(maxSum, sum + sum2);
        }
        return (int) (maxSum % 1000000007);
    }
}