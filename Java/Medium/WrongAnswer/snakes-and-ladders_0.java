class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] nums = new int[n * n];
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == n % 2) {
                for (int j = 0; j < n; j++) {
                    nums[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    nums[idx++] = board[i][j];
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int move = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return move;
                }
                for (int j = curr + 1; j <= Math.min(curr + 6, n * n); j++) {
                    int next = nums[j - 1] == -1 ? j : nums[j - 1];
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            move++;
        }
        return -1;
    }
}