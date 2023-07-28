class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int i = 0, n = buildings.length;
        while (i < n || !pq.isEmpty()) {
            int x = pq.isEmpty() ? buildings[i][0] : pq.peek()[0];
            if (i >= n || buildings[i][0] > x) {
                while (!pq.isEmpty() && pq.peek()[0] <= x) {
                    pq.poll();
                }
            } else {
                x = buildings[i][0];
                while (i < n && buildings[i][0] == x) {
                    pq.offer(new int[]{buildings[i][1], buildings[i][2]});
                    i++;
                }
            }
            int h = pq.isEmpty() ? 0 : pq.peek()[1];
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != h) {
                res.add(Arrays.asList(x, h));
            }
        }
        return res;
    }
}