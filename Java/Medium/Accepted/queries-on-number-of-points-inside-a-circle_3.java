class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < points.length; j++) {
                int x = points[j][0];
                int y = points[j][1];
                int x0 = queries[i][0];
                int y0 = queries[i][1];
                int r = queries[i][2];
                int dist = (x - x0) * (x - x0) + (y - y0) * (y - y0);
                if (dist <= r * r) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}