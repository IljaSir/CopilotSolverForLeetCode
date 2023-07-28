impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        if grid[0][0] == 1 || grid[n - 1][n - 1] == 1 {
            return -1;
        }
        if n == 1 {
            return 1;
        }
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0));
        let mut visited = vec![vec![false; n]; n];
        visited[0][0] = true;
        let mut step = 1;
        while !queue.is_empty() {
            let size = queue.len();
            for _ in 0..size {
                let (x, y) = queue.pop_front().unwrap();
                for i in x.saturating_sub(1)..=x + 1 {
                    for j in y.saturating_sub(1)..=y + 1 {
                        if i == x && j == y {
                            continue;
                        }
                        if i == n - 1 && j == n - 1 {
                            return step + 1;
                        }
                        if i < n && j < n && grid[i][j] == 0 && !visited[i][j] {
                            queue.push_back((i, j));
                            visited[i][j] = true;
                        }
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}