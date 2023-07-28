class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int n = arr.length;
        int l = 0, r = 100000;
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.min(arr[i], mid);
            }
            if (sum >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += Math.min(arr[i], l);
        }
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += Math.min(arr[i], l - 1);
        }
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? l : l - 1;
    }
}