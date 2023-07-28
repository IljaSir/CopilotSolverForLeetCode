class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adj : adjacentPairs) {
            map.putIfAbsent(adj[0], new ArrayList<>());
            map.putIfAbsent(adj[1], new ArrayList<>());
            map.get(adj[0]).add(adj[1]);
            map.get(adj[1]).add(adj[0]);
        }
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[0] = entry.getKey();
                break;
            }
        }
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(res[i - 1]);
            res[i] = res[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return res;
    }
}