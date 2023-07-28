class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            int count = 0;
            for (int j = 0; j < points.length; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                if ((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y) <= r * r) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}