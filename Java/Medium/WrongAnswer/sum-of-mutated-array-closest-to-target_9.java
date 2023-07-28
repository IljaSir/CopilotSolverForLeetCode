class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int l = 0;
        int r = 100000;
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }
            if (sum < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l) {
                sum1 += l;
            } else {
                sum1 += arr[i];
            }
            if (arr[i] > l - 1) {
                sum2 += l - 1;
            } else {
                sum2 += arr[i];
            }
        }
        if (Math.abs(sum1 - target) <= Math.abs(sum2 - target)) {
            return l;
        } else {
            return l - 1;
        }
    }
}