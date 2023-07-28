class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : redEdges) {
            g[e[0]].add(e[1]);
        }
        for (int[] e : blueEdges) {
            g[e[0]].add(e[1] + n);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(0);
        int steps = 0;
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i += 2) {
                int node = q.poll();
                int color = q.poll();
                if (ans[node % n] == -1) {
                    ans[node % n] = steps;
                }
                for (int nei : g[node % n]) {
                    if (nei / n == color || seen.contains(nei)) {
                        continue;
                    }
                    seen.add(nei);
                    q.offer(nei);
                    q.offer(nei / n);
                }
            }
            steps++;
        }
        return ans;
    }
}