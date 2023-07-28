class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] matrix = new int[n][n];
        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int price = curr[0], city = curr[1], stops = curr[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                for (int i = 0; i < n; i++) {
                    if (matrix[city][i] > 0) {
                        pq.offer(new int[]{price + matrix[city][i], i, stops - 1});
                    }
                }
            }
        }
        return -1;
    }
}