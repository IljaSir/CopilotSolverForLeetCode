class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        int[] colorCount = new int[26];
        int[] maxColorCount = new int[n];
        int[] pathCount = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                maxColorCount[i] = 1;
                pathCount[i] = 1;
                colorCount[colors.charAt(i) - 'a']++;
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
                if (maxColorCount[node] > maxColorCount[next]) {
                    maxColorCount[next] = maxColorCount[node];
                    pathCount[next] = pathCount[node];
                    colorCount = new int[26];
                    colorCount[colors.charAt(next) - 'a'] = pathCount[next];
                } else if (maxColorCount[node] == maxColorCount[next]) {
                    pathCount[next] = (pathCount[next] + pathCount[node]) % 1000000007;
                    colorCount[colors.charAt(next) - 'a'] += pathCount[node];
                    maxColorCount[next] = Math.max(maxColorCount[next], colorCount[colors.charAt(next) - 'a']);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] > 0) {
                return -1;
            }
            ans = Math.max(ans, maxColorCount[i]);
        }
        return ans;
    }
}