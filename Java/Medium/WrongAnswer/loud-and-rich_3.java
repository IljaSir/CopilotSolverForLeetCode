class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans[u] = u;
            for (int v : graph[u]) {
                if (ans[v] == -1 || quiet[ans[v]] > quiet[ans[u]]) {
                    ans[v] = ans[u];
                }
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return ans;
    }
}