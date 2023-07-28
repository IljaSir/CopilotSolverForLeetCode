class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new HashMap<>());
            }
            graph.get(time[0]).put(time[1], time[2]);
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int node = 1; node <= n; node++) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dist.put(k, 0);

        boolean[] seen = new boolean[n + 1];
        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) {
                break;
            }

            seen[candNode] = true;
            if (graph.containsKey(candNode)) {
                for (int nei : graph.get(candNode).keySet()) {
                    dist.put(nei, Math.min(dist.get(nei), dist.get(candNode) + graph.get(candNode).get(nei)));
                }
            }
        }

        int ans = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}