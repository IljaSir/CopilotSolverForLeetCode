class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] colorCount = new int[26];
        int[] maxColorCount = new int[n];
        int[] dist = new int[n];
        int res = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            colorCount[colors.charAt(u) - 'a']++;
            for (int v : graph[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
                int max = 0;
                for (int i = 0; i < 26; i++) {
                    max = Math.max(max, colorCount[i]);
                }
                maxColorCount[v] = Math.max(maxColorCount[v], max);
            }
            colorCount[colors.charAt(u) - 'a']--;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] > 0) {
                return -1;
            }
            res = Math.max(res, maxColorCount[i]);
        }
        return res;
    }
}