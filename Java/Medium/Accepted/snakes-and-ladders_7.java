class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;
        int[] arr = new int[n*n];
        int index = 0;
        boolean isLeft = true;
        for(int i = n-1; i >= 0; i--) {
            if(isLeft) {
                for(int j = 0; j < n; j++) {
                    arr[index] = board[i][j];
                    index++;
                }
            } else {
                for(int j = n-1; j >= 0; j--) {
                    arr[index] = board[i][j];
                    index++;
                }
            }
            isLeft = !isLeft;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] visited = new int[n*n];
        visited[0] = 1;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int i = 1; i <= 6; i++) {
                int next = curr + i;
                if(next >= n*n) {
                    break;
                }
                if(arr[next] != -1) {
                    next = arr[next] - 1;
                }
                if(next == n*n - 1) {
                    return visited[curr];
                }
                if(visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[curr] + 1;
                }
            }
        }
        return -1;
    }
}