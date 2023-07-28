class Solution {
    public int findBestValue(int[] arr, int target) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int left = 0;
        int right = arr[n - 1];
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = sum[index - 1] + (n - index) * mid;
            if (cur <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int l1 = getAbs(arr, target, ans);
        int l2 = getAbs(arr, target, ans + 1);
        return l1 <= l2 ? ans : ans + 1;
    }

    private int getAbs(int[] arr, int target, int x) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, x);
        }
        return Math.abs(sum - target);
    }
}