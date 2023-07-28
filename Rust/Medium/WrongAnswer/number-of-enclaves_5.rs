impl Solution {
    pub fn num_enclaves(grid: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (grid.len(), grid[0].len());
        let mut visited = vec![vec![false; n]; m];
        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 && !visited[i][j] {
                    if Self::dfs(&grid, &mut visited, i, j) {
                        count += 1;
                    }
                }
            }
        }
        count
    }
    fn dfs(grid: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize) -> bool {
        let (m, n) = (grid.len(), grid[0].len());
        visited[i][j] = true;
        let mut valid = true;
        if i == 0 || i == m - 1 || j == 0 || j == n - 1 {
            valid = false;
        }
        if i > 0 && grid[i - 1][j] == 1 && !visited[i - 1][j] {
            valid &= Self::dfs(grid, visited, i - 1, j);
        }
        if i < m - 1 && grid[i + 1][j] == 1 && !visited[i + 1][j] {
            valid &= Self::dfs(grid, visited, i + 1, j);
        }
        if j > 0 && grid[i][j - 1] == 1 && !visited[i][j - 1] {
            valid &= Self::dfs(grid, visited, i, j - 1);
        }
        if j < n - 1 && grid[i][j + 1] == 1 && !visited[i][j + 1] {
            valid &= Self::dfs(grid, visited, i, j + 1);
        }
        valid
    }
}