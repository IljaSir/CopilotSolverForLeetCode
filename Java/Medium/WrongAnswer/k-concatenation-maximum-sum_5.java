class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int n = arr.length;
        int mod = 1000000007;
        long sum = 0;
        long max = 0;
        long min = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            total += arr[i];
        }
        if (k == 1) {
            return (int) (max % mod);
        }
        if (total >= 0) {
            return (int) (Math.max(max, total * (k - 2) + max) % mod);
        }
        return (int) (Math.max(max, total * (k - 2) + max - total) % mod);
    }
}