class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int m = n / 3;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    a[j] = slices[i];
                    b[j] = 0;
                } else {
                    a[j] = Math.max(a[j - 1], (j >= 2 ? a[j - 2] : 0) + slices[(i + j) % n]);
                    b[j] = Math.max(b[j - 1], (j >= 2 ? b[j - 2] : 0) + slices[(i + j + 1) % n]);
                }
            }
            result = Math.max(result, Math.max(a[n - 2], b[n - 1]));
        }
        return result;
    }
}