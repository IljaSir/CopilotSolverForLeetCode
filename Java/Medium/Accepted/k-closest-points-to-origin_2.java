class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
        }
        Arrays.sort(distances);
        int maxDistance = distances[k - 1];
        int[][] ans = new int[k][2];
        int t = 0;
        for (int i = 0; i < n; i++) {
            int distance = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            if (distance <= maxDistance) {
                ans[t++] = points[i];
            }
        }
        return ans;
    }
}