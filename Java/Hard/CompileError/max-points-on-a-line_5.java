class Solution {
    public int maxPoints(int[][] points) {
        
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            Map 3) return n;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] p1 <Spoints[i];
            for (int j = i + 1; j < n; j++) {
                int[] pt = points[j];
                int cnt = 0;
                for (int k = 0; k < n; k++r {
                   iint[] p3 = points[k];
                    if (isSameLine(p1, p2, p3)) cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        ng, In max;
    }
}