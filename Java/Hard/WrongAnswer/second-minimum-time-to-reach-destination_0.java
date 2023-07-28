class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(1, 0);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], curDist = cur[1];
            if (node == n) {
                return curDist;
            }
            for (int next : graph.get(node)) {
                int nextDist = curDist + time;
                if (nextDist % change < change / 2) {
                    nextDist += change - nextDist % change;
                } else {
                    nextDist += change * 2 - nextDist % change;
                }
                if (!dist.containsKey(next) || dist.get(next) > nextDist) {
                    dist.put(next, nextDist);
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }
        return -1;
    }
}