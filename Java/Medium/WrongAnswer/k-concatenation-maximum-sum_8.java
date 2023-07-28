class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int n = arr.length;
        long mod = (long) (1e9 + 7);
        long sum = 0;
        long max = 0;
        long min = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        if (k == 1) {
            return (int) (max % mod);
        }
        long prefix = sum;
        long suffix = sum;
        sum *= 2;
        max = 0;
        min = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        sum /= 2;
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            max = Math.max(max, prefix);
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix += arr[i];
            max = Math.max(max, suffix);
        }
        return (int) (Math.max(max, sum) % mod);
    }
}