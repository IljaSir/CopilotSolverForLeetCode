class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        
        List<Integer>[] g = new List[edges.length + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        int[] parent = new int[edges.length + 1];
        int[] count = new int[edges.length + 1];
        Arrays.fill(parent, -1);
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            for (int v : g[u]) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    q.addLast(v);
                }
            }
        }
        for (int[] gues : guesses) {
            int u = gues[0], v = gues[1];
            if (parent[v] == u) {
                count[u]++;
            } else if (parent[u] == v) {
                count[v]++;
            }
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k) {
                res++;
            }
        }
        return res;
    }
}