class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        double lo = 0.0, hi = 1.0;
        while (hi - lo > 1e-9) {
            double mi = (lo + hi) / 2.0;
            int count = 0, p = 0, q = 1;
            for (int i = 0, j = 1; j < arr.length; ++j) {
                while (i < j && arr[i] < mi * arr[j]) ++i;
                count += j - i;
                if (i < j && p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (count == k) return new int[]{p, q};
            if (count > k) hi = mi;
            else lo = mi;
        }
        return new int[]{0, 0};
    }
}