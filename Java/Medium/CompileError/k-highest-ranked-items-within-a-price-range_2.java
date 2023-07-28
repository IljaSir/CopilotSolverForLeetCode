class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int low = pricing[0];
        int high = pricing[1];
        int r = start[0];
        int c = start[1];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            int distA = a.get(0);
            int distB = b.get(0);
            int priceA = a.get(1);
            int priceB = b.get(1);
            int rowA = a.get(2);
            int rowB = b.get(2);
            int colA = a.get(3);
            int colB = b.get(3);
            if (distA != distB) {
                return distB - distA;
            } else if (priceA != priceB) {
                return priceA - priceB;
            } else if (rowA != rowB) {
                return rowA - rowB;
            } else {
                return colA - colB;
            }
        });
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        Set<String> visited = new HashSet<>();
        visited.add(r + "," + c);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int price = grid[row][col];
            if (price >= low && price <= high) {
                pq.add(Arrays.asList(Math.abs(row - r) + Math.abs(col - c), price, row, col));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            int[] dr = new int[]{0, 0, 1, -1};
            int[] dc = new int[]{1, -1, 0, 0};
            for (int i = 0; i < dr.length; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 0 && !visited.contains(nr + "," + nc)) {
                    q.add(new int[]{nr, nc});
                    visited.add(nr + "," + nc);
                }
            }
        }
        List<List<Integer>> res = new ArrayList
    }
}