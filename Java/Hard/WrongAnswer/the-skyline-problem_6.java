class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (buildings.length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int i = 0;
        while (i < buildings.length || !pq.isEmpty()) {
            if (pq.isEmpty() || (i < buildings.length && pq.peek()[0] >= buildings[i][0])) {
                int x = buildings[i][0];
                while (i < buildings.length && buildings[i][0] == x) {
                    pq.offer(new int[]{buildings[i][1], buildings[i][2]});
                    i++;
                }
            } else {
                int x = pq.peek()[0];
                while (!pq.isEmpty() && pq.peek()[0] <= x) {
                    pq.poll();
                }
            }
            int y = pq.isEmpty() ? 0 : pq.peek()[1];
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != y) {
                res.add(Arrays.asList(pq.isEmpty() ? buildings[i - 1][1] : pq.peek()[0], y));
            }
        }
        return res;
    }
}