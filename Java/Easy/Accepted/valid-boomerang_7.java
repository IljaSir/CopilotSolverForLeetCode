class Solution {
    public boolean isBoomerang(int[][] points) {
        
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];
        if (p1[0] == p2[0] && p1[1] == p2[1] || p2[0] == p3[0] && p2[1] == p3[1]) {
            return false;
        }
        if (p1[0] == p3[0] && p1[1] == p3[1]) {
            return false;
        }
        if (p1[0] == p2[0]) {
            return p2[0] != p3[0];
        }
        if (p1[0] == p3[0]) {
            return p2[0] != p3[0];
        }
        if (p2[0] == p3[0]) {
            return p1[0] != p2[0];
        }
        if (p1[1] == p2[1]) {
            return p2[1] != p3[1];
        }
        if (p1[1] == p3[1]) {
            return p2[1] != p3[1];
        }
        if (p2[1] == p3[1]) {
            return p1[1] != p2[1];
        }
        return (p2[1] - p1[1]) * (p3[0] - p2[0]) != (p2[0] - p1[0]) * (p3[1] - p2[1]);
    }
}