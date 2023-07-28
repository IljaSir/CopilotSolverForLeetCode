class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int n = wordList.size();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (diff(wordList.get(i), wordList.get(j))) {
                    graph[i][j] = 1;
                }
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (diff(beginWord, wordList.get(i))) {
                q.add(i);
                dist[i] = 2;
            }
        }
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (wordList.get(i).equals(endWord)) {
                min = Math.min(min, dist[i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
    private boolean diff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}