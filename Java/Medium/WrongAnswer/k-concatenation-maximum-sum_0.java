class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int n = arr.length;
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
        long res = 0;
        if (total > 0) {
            res = Math.max(res, max + total * (k - 2));
        }
        res = Math.max(res, max);
        res = Math.max(res, sum * k);
        return (int)(res % (1000000007));
    }
}