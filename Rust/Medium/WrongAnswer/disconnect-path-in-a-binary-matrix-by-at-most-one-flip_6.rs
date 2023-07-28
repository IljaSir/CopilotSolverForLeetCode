impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = vec![(0, 0)];
        visited[0][0] = true;
        while !queue.is_empty() {
            let mut next_queue = vec![];
            for (x, y) in queue {
                let mut next = vec![(x + 1, y), (x, y + 1)];
                if x == m - 1 && y == n - 1 {
                    return true;
                }
                if grid[x][y] == 0 {
                    next.push((x, y));
                }
                for (nx, ny) in next {
                    if nx < m && ny < n && !visited[nx][ny] {
                        visited[nx][ny] = true;
                        next_queue.push((nx, ny));
                    }
                }
            }
            queue = next_queue;
        }
        false
    }
    pub fn disconnect_path_in_a_binary_matrix(grid: Vec<Vec<i32>>) -> bool {
        let m = grid.len();
        let n = grid[0].len();
        if m == 1 && n == 1 {
            return false;
        }
        if grid[0][0] == 0 {
            return true;
        }
        if grid[m - 1][n - 1] == 0 {
            return true;
        }
        if grid[0][0] == 1 && grid[m - 1][n - 1] == 1 {
            return !Self::is_possible_to_cut_path(grid);
        }
        false
    }
}