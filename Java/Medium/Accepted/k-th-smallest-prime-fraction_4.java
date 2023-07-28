class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        double left = 0, right = 1;
        while (true) {
            double mid = (left + right) / 2;
            int count = 0, p = 0, q = 1;
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && arr[i] > mid * arr[j]) j++;
                count += n - j;
                if (j < n && p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (count == k) return new int[] {p, q};
            if (count > k) right = mid;
            else left = mid;
        }
    }
}