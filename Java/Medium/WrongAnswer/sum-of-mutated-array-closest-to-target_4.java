class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int l = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {
            r = Math.max(r, arr[i]);
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Math.min(arr[i], m);
            }
            if (sum < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(arr[i], l);
        }
        if (sum == target) {
            return l;
        }
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum2 += Math.min(arr[i], l + 1);
        }
        if (Math.abs(target - sum) <= Math.abs(target - sum2)) {
            return l;
        }
        return l + 1;
    }
}