class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int low = pricing[0];
        int high = pricing[1];
        int row = start[0];
        int col = start[1];
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                if (a[1] < b[1]) {
                    return -1;
                } else if (a[1] > b[1]) {
                    return 1;
                } else {
                    if (a[2] < b[2]) {
                        return -1;
                    } else if (a[2] > b[2]) {
                        return 1;
                    } else {
                        if (a[3] < b[3]) {
                            return -1;
                        } else if (a[3] > b[3]) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        });
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        int[][] price = new int[m][n];
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                if (a[1] < b[1]) {
                    return -1;
                } else if (a[1] > b[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            if (visited[curRow][curCol]) {
                continue;
            }
            visited[curRow][curCol] =
    }
}