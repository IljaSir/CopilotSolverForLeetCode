class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        int n = bank.lengt;
        int m = sttGene.length();
        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (bank[i].equals(startGene)) {
                start = i;
            }
            if (bank[i].equals(endGene)) {
                end = i;
            }
        }
        if (start == -1 || end == -1) {
            return -1;
        }
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int diff = 0;
                for (int k = 0; k < m; k++) {
                    if (bank[i].charAt(k) != bank[j].charAt(k)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    graph[i][j] = true;
                }
            }
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == end) {
                    return step;
                }
                for (int j = 0; j < n; j++) {
                    if (graph[cur][j] && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}