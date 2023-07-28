class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int[] ans = new int[2];
        double l = 0.0, r = 1.0;
        while (l < r) {
            double mid = l + (r - l) / 2;
            int cnt = 0;
            int p = 0;
            for (int i = 0, j = 1; j < arr.length; ) {
                if (arr[i] * 1.0 / arr[j] < mid) {
                    if (p * arr[j] < arr[i]) {
                        p = arr[i];
                        ans[0] = arr[i];
                        ans[1] = arr[j];
                    }
                    cnt += arr.length - j;
                    i++;
                } else {
                    j++;
                }
            }
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return ans;
    }
}