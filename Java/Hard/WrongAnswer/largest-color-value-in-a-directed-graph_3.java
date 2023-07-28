class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        int[] inDegree = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }
        int[] maxCount = new int[26];
        int[] currentCount = new int[26];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (!dfs(i, colors, graph, inDegree, maxCount, currentCount, visited)) {
                    return -1;
                }
            }
        }
        return Arrays.stream(maxCount).max().getAsInt();
    }

    private boolean dfs(int node, String colors, List<Integer>[] graph, int[] inDegree, int[] maxCount, int[] currentCount, int[] visited) {
        visited[node] = 1;
        currentCount[colors.charAt(node) - 'a']++;
        maxCount[colors.charAt(node) - 'a'] = Math.max(maxCount[colors.charAt(node) - 'a'], currentCount[colors.charAt(node) - 'a']);
        for (int next : graph[node]) {
            inDegree[next]--;
            if (inDegree[next] == 0) {
                if (!dfs(next, colors, graph, inDegree, maxCount, currentCount, visited)) {
                    return false;
                }
            } else if (visited[next] == 1) {
                return false;
            }
        }
        currentCount[colors.charAt(node) - 'a']--;
        visited[node] = 2;
        return true;
    }
}