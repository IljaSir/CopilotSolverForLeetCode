class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int d12 = dist(p1, p2);
        int d13 = dist(p1, p3);
        int d14 = dist(p1, p4);
        int d23 = dist(p2, p3);
        int d24 = dist(p2, p4);
        int d34 = dist(p3, p4);
        if (d12 == 0 || d13 == 0 || d14 == 0 || d23 == 0 || d24 == 0 || d34 == 0) return false;
        int[] d = new int[]{d12, d13, d14, d23, d24, d34};
        Arrays.sort(d);
        return d[0] == d[1] && d[1] == d[2] && d[2] == d[3] && d[4] == d[5] && d[4] == 2 * d[0];
    }
}