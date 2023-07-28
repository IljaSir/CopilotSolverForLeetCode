class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        if (sum <= target) {
            return max;
        }
        int l = 0;
        int r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            int newSum = 0;
            for (int i = 0; i < arr.length; i++) {
                newSum += Math.min(arr[i], mid);
            }
            if (newSum >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += Math.min(arr[i], l - 1);
        }
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum2 += Math.min(arr[i], l);
        }
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? l - 1 : l;
    }
}