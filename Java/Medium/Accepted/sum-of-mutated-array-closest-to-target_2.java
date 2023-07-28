class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        if (sum <= target) {
            return max;
        }
        int l = 0, r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            int curSum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    curSum += mid;
                } else {
                    curSum += arr[i];
                }
            }
            if (curSum <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int s1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l - 1) {
                s1 += l - 1;
            } else {
                s1 += arr[i];
            }
        }
        int s2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l) {
                s2 += l;
            } else {
                s2 += arr[i];
            }
        }
        return Math.abs(s1 - target) <= Math.abs(s2 - target) ? l - 1 : l;
    }
}