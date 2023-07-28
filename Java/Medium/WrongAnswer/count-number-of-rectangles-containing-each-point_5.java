class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] res = new int[points.length];
        int[] x = new int[rectangles.length];
        int[] y = new int[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            x[i] = rectangles[i][0];
            y[i] = rectangles[i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < points.length; i++) {
            int left = 0;
            int right = rectangles.length - 1;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (x[mid] < points[i][0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int indexX = left;
            if (x[indexX] < points[i][0]) {
                indexX++;
            }
            left = 0;
            right = rectangles.length - 1;
            while (left < right) {
                mid = (left + right) / 2;
                if (y[mid] < points[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int indexY = left;
            if (y[indexY] < points[i][1]) {
                indexY++;
            }
            res[i] = indexX * indexY;
        }
        return res;
    }
}