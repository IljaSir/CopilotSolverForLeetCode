class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int N = board.length;
        int[] nums = new int[N * N + 1];
        int i = N - 1, j = 0, idx = 1, inc = 1;
        while (idx <= N * N) {
            nums[idx++] = board[i][j];
            if (inc == 1 && j == N - 1) {
                inc = -1;
                i--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else {
                j += inc;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int steps = 0;
        boolean[] visited = new boolean[N * N + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                if (cur == N * N) {
                    return steps;
                }
                for (int m = 1; m <= 6; m++) {
                    int next = cur + m;
                    if (next > N * N) {
                        break;
                    }
                    if (nums[next] != -1) {
                        next = nums[next];
                    }
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}