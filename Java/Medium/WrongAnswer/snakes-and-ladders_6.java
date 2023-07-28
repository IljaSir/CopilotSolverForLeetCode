class Solution {
    public int snakesAndLadders(int[][] board) {
        
        if (board == null || board.length == 0) {
            return 0;
        }
        int n = board.length;
        int[] arr = new int[n * n];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == n % 2) {
                for (int j = 0; j < n; j++) {
                    arr[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    arr[index++] = board[i][j];
                }
            }
        }
        boolean[] visited = new boolean[n * n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n - 1) {
                    return steps;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    if (next >= n * n) {
                        break;
                    }
                    if (arr[next] != -1) {
                        next = arr[next] - 1;
                    }
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            steps++;
        }
        return -1;
    }
}