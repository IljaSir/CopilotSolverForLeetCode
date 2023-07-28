class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] count = new int[points.length];
        int[] x = new int[rectangles.length];
        int[] y = new int[rectangles.length];
        for(int i = 0; i < rectangles.length; i++) {
            x[i] = rectangles[i][0];
            y[i] = rectangles[i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for(int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int xIndex = Arrays.binarySearch(x, point[0]);
            if(xIndex < 0) {
                xIndex = -xIndex - 1;
            }
            int yIndex = Arrays.binarySearch(y, point[1]);
            if(yIndex < 0) {
                yIndex = -yIndex - 1;
            }
            count[i] = xIndex * yIndex;
        }
        return count;
    }
}