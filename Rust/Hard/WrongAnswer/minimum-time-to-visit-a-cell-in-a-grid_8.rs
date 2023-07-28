impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let n = grid.len();
        let m = grid[0].len();
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0, 0));
        let mut visited = vec![vec![false; m]; n];
        visited[0][0] = true;
        while let Some((x, y, t)) = q.pop_front() {
            if x == n - 1 && y == m - 1 {
                return t;
            }
            if x > 0 && !visited[x - 1][y] && grid[x - 1][y] <= t + 1 {
                visited[x - 1][y] = true;
                q.push_back((x - 1, y, t + 1));
            }
            if x < n - 1 && !visited[x + 1][y] && grid[x + 1][y] <= t + 1 {
                visited[x + 1][y] = true;
                q.push_back((x + 1, y, t + 1));
            }
            if y > 0 && !visited[x][y - 1] && grid[x][y - 1] <= t + 1 {
                visited[x][y - 1] = true;
                q.push_back((x, y - 1, t + 1));
            }
            if y < m - 1 && !visited[x][y + 1] && grid[x][y + 1] <= t + 1 {
                visited[x][y + 1] = true;
                q.push_back((x, y + 1, t + 1));
            }
        }
        -1
    }
}