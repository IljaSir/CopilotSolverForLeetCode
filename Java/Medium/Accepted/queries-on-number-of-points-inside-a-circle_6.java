class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int[] point : points) {
                if (Math.sqrt(Math.pow(point[0] - queries[i][0], 2) + Math.pow(point[1] - queries[i][1], 2)) <= queries[i][2]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}