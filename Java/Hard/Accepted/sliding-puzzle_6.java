class Solution {
    public int slidingPuzzle(int[][] board) {
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] start = new int[6];
        int[] end = {1, 2, 3, 4, 5, 0};
        int idx = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start[idx++] = board[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(start);
        Set<String> visited = new HashSet<String>();
        visited.add(Arrays.toString(start));
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (Arrays.equals(cur, end)) {
                    return steps;
                }
                int zeroIdx = 0;
                for (int j = 0; j < 6; j++) {
                    if (cur[j] == 0) {
                        zeroIdx = j;
                        break;
                    }
                }
                int row = zeroIdx / 3;
                int col = zeroIdx % 3;
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newRow >= 2 || newCol < 0 || newCol >= 3) {
                        continue;
                    }
                    int swapIdx = newRow * 3 + newCol;
                    swap(cur, zeroIdx, swapIdx);
                    if (!visited.contains(Arrays.toString(cur))) {
                        q.offer(Arrays.copyOf(cur, cur.length));
                        visited.add(Arrays.toString(cur));
                    }
                    swap(cur, zeroIdx, swapIdx);
                }
            }
            steps++;
        }
        return -1;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}