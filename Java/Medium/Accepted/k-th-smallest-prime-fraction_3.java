class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        int[] result = new int[2];
        double low = 0, high = 1;
        while (low < high) {
            double mid = (low + high) / 2;
            int[] count = new int[1];
            int[] p = new int[1];
            int[] q = new int[1];
            p[0] = 0;
            q[0] = 1;
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                count[0] += n - j;
                if (j < n && p[0] * arr[j] < q[0] * arr[i]) {
                    p[0] = arr[i];
                    q[0] = arr[j];
                }
            }
            if (count[0] == k) {
                result[0] = p[0];
                result[1] = q[0];
                break;
            } else if (count[0] < k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return result;
    }
}