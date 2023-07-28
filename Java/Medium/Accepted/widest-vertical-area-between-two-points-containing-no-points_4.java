class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            max = Math.max(max, points[i + 1][0] - points[i][0]);
        }
        return max;
    }
}