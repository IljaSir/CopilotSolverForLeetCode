impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        // BFS
        let mut grid = grid;
        let n = grid.len();
        if grid[0][0] == 1 || grid[n - 1][n - 1] == 1 {
            return -1;
        }
        if n == 1 {
            return 1;
        }
        let mut queue = Vec::new();
        queue.push((0, 0));
        grid[0][0] = 1;
        let mut step = 1;
        while !queue.is_empty() {
            let mut next = Vec::new();
            for (i, j) in queue {
                for (x, y) in vec![(i - 1, j), (i, j - 1), (i + 1, j), (i, j + 1), (i - 1, j - 1), (i + 1, j + 1), (i - 1, j + 1), (i + 1, j - 1)] {
                    if x < n && y < n && x >= 0 && y >= 0 && grid[x][y] == 0 {
                        if x == n - 1 && y == n - 1 {
                            return step + 1;
                        }
                        next.push((x, y));
                        grid[x][y] = 1;
                    }
                }
            }
            queue = next;
            step += 1;
        }
        -1
    }
}