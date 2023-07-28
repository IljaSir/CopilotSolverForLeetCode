class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[][] ps = new int[][]{p1, p2, p3, p4};
        Arrays.sort(ps, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int[] p1_ = ps[0];
        int[] p2_ = ps[1];
        int[] p3_ = ps[2];
        int[] p4_ = ps[3];
        int[] d1 = new int[]{p1_[0] - p2_[0], p1_[1] - p2_[1]};
        int[] d2 = new int[]{p1_[0] - p3_[0], p1_[1] - p3_[1]};
        int[] d3 = new int[]{p1_[0] - p4_[0], p1_[1] - p4_[1]};
        if (d1[0] * d2[0] + d1[1] * d2[1] != 0) {
            return false;
        }
        if (d1[0] * d3[0] + d1[1] * d3[1] != 0) {
            return false;
        }
        int d1_ = d1[0] * d1[0] + d1[1] * d1[1];
        int d2_ = d2[0] * d2[0] + d2[1] * d2[1];
        int d3_ = d3[0] * d3[0] + d3[1] * d3[1];
        if (d1_ == 0 || d2_ == 0 || d3_ == 0) {
            return false;
        }
        return d1_ == d2_ && d2_ == d3_;
    }
}