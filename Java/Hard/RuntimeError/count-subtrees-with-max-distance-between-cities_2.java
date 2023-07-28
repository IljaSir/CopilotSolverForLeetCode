class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] result = new int[n - 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (int i = 1; i < (1 << n); i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                }
            }
            if (count <= 1) {
                continue;
            }
            int[] max = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            int[] queue = new int[n + 1];
            int start = -1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    start = j + 1;
                    break;
                }
            }
            int head = 0;
            int tail = 1;
            queue[head] = start;
            visited[start] = true;
            while (head < tail) {
                int node = queue[head++];
                for (int next : graph[node]) {
                    if (!visited[next] && (i & (1 << (next - 1))) != 0) {
                        visited[next] = true;
                        queue[tail++] = next;
                        max[next] = max[node] + 1;
                    }
                }
            }
            int maxDistance = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    maxDistance = Math.max(maxDistance, max[j + 1]);
                }
            }
            result[maxDistance - 1]++;
        }
        return result;
    }
}