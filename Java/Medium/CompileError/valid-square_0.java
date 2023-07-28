class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[][] points = new int[4][2];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] p0 = points[0];
        int[] p1 = points[1];
        int[] p2 = points[2];
        int[] p3 = points[3];
        if (p0[0] == p1[0] && p0[1] == p1[1]) {
            return false;
        }
        if (p0[0] == p2[0] && p0[1] == p2[1]) {
            return false;
        }
        if (p0[0] == p3[0] && p0[1] == p3[1]) {
            return false;
        }
        if (p1[0] == p2[0] && p1[1] == p2[1]) {
            return false;
        }
        if (p1[0] == p3[0] && p1[1] == p3[1]) {
            return false;
        }
        if (p2[0] == p3[0] && p2[1] == p3[1]) {
            return false;
        }
        int[] v1 = new int[] {p1[0] - p0[0], p1[1] - p0[1]};
        int[] v2 = new int[] {p2[0] - p0[0], p2[1] - p0[1]};
        int[] v3 = new int[] {p3[0] - p0[0], p3[1] - p0[1]};
        if (v1[0] * v1[0] + v1[1] * v1[1] != v2[0] * v2[0] + v2[1] * v2[1]) {
            return false;
        }
        if (v1[0] *
    }
}