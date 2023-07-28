class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length;
        if (n < 3) return n;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    int[] p3 = points[k];
                    if (isSameLine(p1, p2, p3)) cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}