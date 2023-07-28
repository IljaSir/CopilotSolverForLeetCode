class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] flat = new int[n*n];
        int index = 0;
        boolean isReverse = false;
        for(int i = n-1; i >= 0; i--) {
            if(isReverse) {
                for(int j = n-1; j >= 0; j--) {
                    flat[index++] = board[i][j];
                }
            } else {
                for(int j = 0; j < n; j++) {
                    flat[index++] = board[i][j];
                }
            }
            isReverse = !isReverse;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                if(curr == n*n-1) {
                    return steps;
                }
                for(int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    if(next >= n*n) {
                        break;
                    }
                    if(flat[next] != -1) {
                        next = flat[next] - 1;
                    }
                    if(next == n*n-1) {
                        return steps+1;
                    }
                    if(flat[next] != -2) {
                        queue.add(next);
                        flat[next] = -2;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}