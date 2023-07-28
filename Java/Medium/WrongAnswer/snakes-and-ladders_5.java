class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] nums = new int[n * n];
        int ind = 0;
        boolean reverse = false;
        for (int i = n - 1; i >= 0; i--) {
            if (reverse) {
                for (int j = n - 1; j >= 0; j--) {
                    nums[ind++] = board[i][j];
                }
            } else {
                for (int j = 0; j < n; j++) {
                    nums[ind++] = board[i][j];
                }
            }
            reverse = !reverse;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n * n];
        visited[0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == n * n - 1) {
                    return step;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = cur + j;
                    if (next < n * n && !visited[next]) {
                        if (nums[next] > 0) {
                            next = nums[next] - 1;
                        }
                        if (!visited[next]) {
                            queue.add(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}