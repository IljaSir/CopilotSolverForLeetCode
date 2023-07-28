class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge: edges) {
            graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, maxMoves});
        Map<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (!seen.containsKey(node[0])) {
                seen.put(node[0], node[1]);
                for (int[] nei: graph.getOrDefault(node[0], new ArrayList<>())) {
                    int moves = node[1] - nei[1] - 1;
                    if (!seen.containsKey(nei[0]) && moves >= 0)
                        pq.offer(new int[]{nei[0], moves});
                }
            }
        }
        int res = seen.size();
        for (int[] edge: edges) {
            int a = seen.getOrDefault(edge[0], 0);
            int b = seen.getOrDefault(edge[1], 0);
            res += Math.min(edge[2], a + b);
        }
        return res;
    }
}