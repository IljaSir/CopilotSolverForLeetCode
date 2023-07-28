class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] b = new int[n * n];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (index % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    b[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    b[index++] = board[i][j];
                }
            }
        }
        int[] steps = new int[n * n];
        Arrays.fill(steps, -1);
        steps[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 1; i <= 6 && curr + i < n * n; i++) {
                int next = curr + i;
                if (b[next] != -1) {
                    next = b[next] - 1;
                }
                if (steps[next] == -1) {
                    steps[next] = steps[curr] + 1;
                    q.add(next);
                }
            }
        }
        return steps[n * n - 1];
    }
}