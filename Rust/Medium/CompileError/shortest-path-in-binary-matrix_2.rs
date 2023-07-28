impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        if grid[0][0] == 1 || grid[n - 1][n - 1] == 1 {
            return -1;
        }
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0, 1));
        while !queue.is_empty() {
            let (x, y, step) = queue.pop_front().unwrap();
            if x == n - 1 && y == n - 1 {
                return step;
            }
            for i in x.saturating_sub(1)..=x + 1 {
                for j in y.saturating_sub(1)..=y + 1 {
                    if i < n && j < n && grid[i][j] == 0 {
                        grid[i][j] = 1;
                        queue.push_back((i, j, step + 1));
                    }
                }
            }
        }
        -1
    }
}