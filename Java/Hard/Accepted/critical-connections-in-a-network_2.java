class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> c : connections) {
            graph.get(c.get(0)).add(c.get(1));
            graph.get(c.get(1)).add(c.get(0));
        }
        int[] ids = new int[n];
        Arrays.fill(ids, -1);
        int[] lows = new int[n];
        Arrays.fill(lows, -1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int id = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) {
                dfs(i, id, ids, lows, parent, graph, res);
            }
        }
        return res;
    }

    private void dfs(int at, int id, int[] ids, int[] lows, int[] parent, List<List<Integer>> graph, List<List<Integer>> res) {
        ids[at] = id;
        lows[at] = id;
        id++;
        for (int to : graph.get(at)) {
            if (ids[to] == -1) {
                parent[to] = at;
                dfs(to, id, ids, lows, parent, graph, res);
                lows[at] = Math.min(lows[at], lows[to]);
                if (lows[to] > ids[at]) {
                    res.add(Arrays.asList(at, to));
                }
            } else if (to != parent[at]) {
                lows[at] = Math.min(lows[at], ids[to]);
            }
        }
    }
}