class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);

        for (int[] point : points) {
            pq.offer(new int[]{point[0] * point[0] + point[1] * point[1], point[0], point[1]});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        while (k-- > 0) {
            int[] point = pq.poll();
            ans[k][0] = point[1];
            ans[k][1] = point[2];
        }
        return ans;
    }
}