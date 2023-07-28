class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int n = arr.length;
        Arrays.sort(arr);
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        int l = 0, r = arr[n - 1];
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int idx = Arrays.binarySearch(arr, mid);
            if (idx < 0) {
                idx = -idx - 1;
            }
            int cur = preSum[idx] + (n - idx) * mid;
            if (cur <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int sum1 = getSum(arr, ans);
        int sum2 = getSum(arr, ans + 1);
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? ans : ans + 1;
    }

    public int getSum(int[] arr, int x) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, x);
        }
        return sum;
    }
}