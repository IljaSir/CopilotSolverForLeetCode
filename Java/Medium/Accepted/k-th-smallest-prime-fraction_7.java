class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        double l = 0, r = 1;
        double[] res = new double[2];
        while (l < r) {
            double m = (l + r) / 2;
            int[] p = new int[]{-1, 1};
            int count = 0;
            for (int i = 0, j = 1; i < n - 1; i++) {
                while (j < n && arr[i] > m * arr[j]) j++;
                if (j == n) break;
                count += n - j;
                if (p[0] == -1 || arr[i] * p[1] > arr[j] * p[0]) {
                    p[0] = arr[i];
                    p[1] = arr[j];
                }
            }
            if (count == k) {
                res[0] = p[0];
                res[1] = p[1];
                break;
            }
            if (count > k) r = m;
            else l = m;
        }
        return new int[]{(int)res[0], (int)res[1]};
    }
}