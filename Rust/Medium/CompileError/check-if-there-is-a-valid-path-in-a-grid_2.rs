impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0));
        while let Some((i, j)) = q.pop_front() {
            if i == m - 1 && j == n - 1 {
                return true;
            }
            visited[i][j] = true;
            match grid[i][j] {
                1 => {
                    if j > 0 && !visited[i][j - 1] && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6) {
                        q.push_back((i, j - 1));
                    }
                    if j < n - 1 && !visited[i][j + 1] && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5) {
                        q.push_back((i, j + 1));
                    }
                },
                2 => {
                    if i > 0 && !visited[i - 1][j] && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4) {
                        q.push_back((i - 1, j));
                    }
                    if i < m - 1 && !visited[i + 1][j] && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6) {
                        q.push_back((i + 1, j));
                    }
                },
                3 => {
                    if j > 0 && !visited[i][j - 1] && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6) {
                        q.push_back((i, j - 1));
                    }
                    if i < m - 1 && !visited[i + 1][j] && (grid
    }
}