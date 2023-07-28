class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1] + arr[i], arr[i]);
            right[n - i - 1] = Math.max(right[n - i] + arr[n - i - 1], arr[n - i - 1]);
        }
        int res = arr[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, left[i]);
            if (i > 0 && i < n - 1) {
                res = Math.max(res, left[i - 1] + right[i + 1]);
            }
        }
        return res;
    }
}