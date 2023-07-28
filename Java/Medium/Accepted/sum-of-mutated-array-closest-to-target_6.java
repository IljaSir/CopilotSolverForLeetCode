class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int l = 0, r = 0;
        for (int a : arr) {
            r = Math.max(r, a);
        }
        while (l < r) {
            int m = (l + r) / 2;
            int sum = 0;
            for (int a : arr) {
                sum += Math.min(a, m);
            }
            if (sum < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int sum1 = 0, sum2 = 0;
        for (int a : arr) {
            sum1 += Math.min(a, l - 1);
            sum2 += Math.min(a, l);
        }
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? l - 1 : l;
    }
}