class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[][] points = new int[][] {p1, p2, p3, p4};
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        boolean isSquare = true;
        if (points[0][0] == points[1][0] && points[1][0] == points[2][0] && points[2][0] == points[3][0]) {
            isSquare = false;
        } else if (points[0][1] == points[1][1] && points[1][1] == points[2][1] && points[2][1] == points[3][1]) {
            isSquare = false;
        } else if (points[0][0] == points[1][0] && points[2][0] == points[3][0] && points[1][1] == points[2][1] && points[0][1] == points[3][1]) {
            isSquare = true;
        } else if (points[0][0] == points[2][0] && points[1][0] == points[3][0] && points[0][1] == points[2][1] && points[1][1] == points[3][1]) {
            isSquare = true;
        } else {
            isSquare = false;
        }
        return isSquare;
    }
}