impl Solution {
    pub fn num_enclaves(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let (m, n) = (grid.len(), grid[0].len());
        for i in 0..m {
            for j in 0..n {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1 {
                    Self::dfs(&mut grid, i, j);
                }
            }
        }
        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    count += 1;
                }
            }
        }
        count
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) {
        let (m, n) = (grid.len(), grid[0].len());
        if i >= m || j >= n || grid[i][j] == 0 {
            return;
        }
        grid[i][j] = 0;
        Self::dfs(grid, i + 1, j);
        Self::dfs(grid, i, j + 1);
        if i > 0 {
            Self::dfs(grid, i - 1, j);
        }
        if j > 0 {
            Self::dfs(grid, i, j - 1);
        }
    }
}