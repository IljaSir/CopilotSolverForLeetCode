class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] arr = new int[n * n];
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if ((n - i) % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    arr[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    arr[idx++] = board[i][j];
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] visited = new int[n * n];
        visited[0] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n * n - 1) {
                    return visited[curr] - 1;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    if (next >= n * n) {
                        break;
                    }
                    if (arr[next] != -1) {
                        next = arr[next] - 1;
                    }
                    if (visited[next] == 0) {
                        visited[next] = visited[curr] + 1;
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}