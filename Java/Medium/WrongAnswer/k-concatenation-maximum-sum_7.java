class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int n = arr.length;
        long mod = 1000000007;
        long max = 0;
        long sum = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        if (k == 1) {
            return (int) (max % mod);
        }
        long res = 0;
        if (total > 0) {
            res = max + (k - 2) * total;
        } else {
            res = max;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            res = Math.max(res, sum);
        }
        return (int) (res % mod);
    }
}