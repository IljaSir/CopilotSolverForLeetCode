class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            pq.add(new int[]{distance, point[0], point[1]});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            result[i++] = new int[]{point[1], point[2]};
        }
        return result;
    }
}