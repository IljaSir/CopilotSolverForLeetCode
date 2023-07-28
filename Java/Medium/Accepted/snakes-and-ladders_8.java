class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] d = new int[n * n + 1];
        int r = n - 1, c = 0, k = 1, dir = 1;
        while (k <= n * n) {
            d[k] = board[r][c];
            if (dir == 1) {
                c++;
                if (c == n) {
                    r--;
                    dir = -1;
                    c--;
                }
            } else {
                c--;
                if (c < 0) {
                    r--;
                    dir = 1;
                    c++;
                }
            }
            k++;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] visited = new int[n * n + 1];
        visited[1] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = curr + 1; i <= Math.min(curr + 6, n * n); i++) {
                int next = d[i] == -1 ? i : d[i];
                if (next == n * n) return visited[curr];
                if (visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[curr] + 1;
                }
            }
        }
        return -1;
    }
}