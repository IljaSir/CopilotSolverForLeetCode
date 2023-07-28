class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        Map<Integer, Set<Integer>> restrictedMap = new HashMap<>();
        for (int i = 0; i < restricted.length; i++) {
            restrictedMap.putIfAbsent(restricted[i], new HashSet<>());
            restrictedMap.get(restricted[i]).add(i);
        }

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.add(new int[]{0, n - 1});
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!visited.add(cur[0])) {
                continue;
            }
            res++;
            if (restrictedMap.containsKey(cur[0])) {
                for (int i : restrictedMap.get(cur[0])) {
                    if (cur[1] >= restricted[i]) {
                        res += restricted[i] + 1;
                        cur[1] -= restricted[i] + 1;
                    } else {
                        res += cur[1] + 1;
                        cur[1] = -1;
                    }
                }
            }
            if (cur[1] <= 0) {
                continue;
            }
            for (int[] next : graph.getOrDefault(cur[0], Collections.emptyList())) {
                if (!visited.contains(next[0])) {
                    pq.add(new int[]{next[0], Math.min(cur[1], next[1])});
                }
            }
        }
        return res;
    }
}