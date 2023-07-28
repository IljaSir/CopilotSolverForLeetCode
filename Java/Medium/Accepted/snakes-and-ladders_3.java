class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] nums = new int[n * n];
        int i = n - 1, j = 0, idx = 0, inc = 1;
        while (idx < n * n) {
            nums[idx++] = board[i][j];
            j += inc;
            if (j >= n || j < 0) {
                i--;
                inc = -inc;
                j += inc;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n * n];
        visited[0] = true;
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                if (cur == n * n - 1) return moves;
                for (int d = 1; d <= 6; d++) {
                    int next = cur + d;
                    if (next >= n * n) break;
                    if (nums[next] != -1) next = nums[next] - 1;
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}