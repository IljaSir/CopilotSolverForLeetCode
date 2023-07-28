class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = colors.charAt(i) - 'a';
        }
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[][] count = new int[n][26];
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int u = queue.poll();
                int c = color[u];
                count[u][c]++;
                res = Math.max(res, count[u][c]);
                for (int v : graph[u]) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        queue.add(v);
                    }
                    for (int i = 0; i < 26; i++) {
                        count[v][i] = Math.max(count[v][i], count[u][i]);
                    }
                }
                size--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] > 0) {
                return -1;
            }
        }
        return res;
    }
}