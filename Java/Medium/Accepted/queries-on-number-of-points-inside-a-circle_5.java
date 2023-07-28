class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1], r = queries[i][2];
            int cnt = 0;
            for (int[] point : points) {
                if (Math.pow(point[0] - x, 2) + Math.pow(point[1] - y, 2) <= Math.pow(r, 2)) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}