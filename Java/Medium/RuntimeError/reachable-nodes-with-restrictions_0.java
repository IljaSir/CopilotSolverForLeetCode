class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.putIfAbsent(edge[1], new HashMap<>());
            graph.get(edge[0]).put(edge[1], edge[2]);
            graph.get(edge[1]).put(edge[0], edge[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, 0});
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> moves = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!seen.add(cur[0])) continue;
            moves.put(cur[0], cur[1]);
            if (graph.containsKey(cur[0])) {
                for (int nei : graph.get(cur[0]).keySet()) {
                    int move = cur[1] + graph.get(cur[0]).get(nei) + 1;
                    if (!seen.contains(nei) && move > 0) {
                        pq.offer(new int[]{nei, move});
                    }
                }
            }
        }
        int res = moves.size();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], len = edge[2];
            int aMove = moves.getOrDefault(a, 0);
            int bMove = moves.getOrDefault(b, 0);
            res += Math.min(len, aMove + bMove);
        }
        for (int i : restricted) {
            if (moves.containsKey(i)) res--;
        }
        return res;
    }
}