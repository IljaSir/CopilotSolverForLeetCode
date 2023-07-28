class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[][] points = new int[][]{p1, p2, p3, p4};
        int[] lengths = new int[6];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                lengths[index++] = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
            }
        }
        Arrays.sort(lengths);
        return lengths[0] == lengths[1] && lengths[1] == lengths[2] && lengths[2] == lengths[3] && lengths[4] == lengths[5] && lengths[0] != lengths[4];
    }
}