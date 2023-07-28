class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int mod = (int)1e9+7;
        int n = rectangles.length;
        long ans = 0;
        int[] x = new int[2 * n];
        int[] y = new int[2 * n];
        for (int i = 0; i < n; i++) {
            x[2 * i] = rectangles[i][0];
            x[2 * i + 1] = rectangles[i][2];
            y[2 * i] = rectangles[i][1];
            y[2 * i + 1] = rectangles[i][3];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < n; i++) {
            int x1 = Arrays.binarySearch(x, rectangles[i][0]);
            int x2 = Arrays.binarySearch(x, rectangles[i][2]);
            int y1 = Arrays.binarySearch(y, rectangles[i][1]);
            int y2 = Arrays.binarySearch(y, rectangles[i][3]);
            ans = (ans + (long)(x2 - x1) * (y2 - y1)) % mod;
        }
        for (int i = 1; i < 2 * n; i++) {
            int width = x[i] - x[i - 1];
            for (int j = 1; j < 2 * n; j++) {
                int height = y[j] - y[j - 1];
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (x[i - 1] >= rectangles[k][0] && x[i - 1] < rectangles[k][2] && y[j - 1] >= rectangles[k][1] && y[j - 1] < rectangles[k][3]) {
                        cnt++;
                    }
                }
                if (cnt > 1) {
                    ans = (ans - (long)width * height % mod + mod) % mod;
                }
            }
        }
        return (int)ans;
    }
}