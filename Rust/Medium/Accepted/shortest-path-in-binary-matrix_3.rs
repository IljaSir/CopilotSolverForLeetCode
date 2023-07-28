impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        if grid[0][0] == 1 || grid[n-1][n-1] == 1 {
            return -1;
        }
        let mut q = std::collections::VecDeque::new();
        let mut visited = vec![vec![false; n]; n];
        q.push_back((0, 0));
        visited[0][0] = true;
        let mut step = 1;
        while !q.is_empty() {
            let size = q.len();
            for _ in 0..size {
                let (x, y) = q.pop_front().unwrap();
                if x == n-1 && y == n-1 {
                    return step;
                }
                for i in x.saturating_sub(1)..=x+1 {
                    for j in y.saturating_sub(1)..=y+1 {
                        if i == x && j == y {
                            continue;
                        }
                        if i < n && j < n && !visited[i][j] && grid[i][j] == 0 {
                            visited[i][j] = true;
                            q.push_back((i, j));
                        }
                    }
                }
            }
            step += 1;
        }
        -1
    }
}