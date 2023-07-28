class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        int[] inDegree = new int[n];
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adjList[e[0]].add(e[1]);
            inDegree[e[1]]++;
        }
        int[] colorCount = new int[26];
        int[] maxColorCount = new int[n];
        int[] maxColor = new int[n];
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            colorCount[colors.charAt(cur) - 'a']++;
            for (int i = 0; i < 26; i++) {
                if (colorCount[i] > maxColorCount[cur]) {
                    maxColorCount[cur] = colorCount[i];
                    maxColor[cur] = i;
                }
            }
            for (int nei : adjList[cur]) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
                if (maxColor[cur] == maxColor[nei]) {
                    maxColorCount[nei] = Math.max(maxColorCount[nei], maxColorCount[cur]);
                } else {
                    maxColorCount[nei] = Math.max(maxColorCount[nei], maxColorCount[cur] + 1);
                }
            }
            colorCount[colors.charAt(cur) - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] != 0) {
                return -1;
            }
            res = Math.max(res, maxColorCount[i]);
        }
        return res;
    }
}