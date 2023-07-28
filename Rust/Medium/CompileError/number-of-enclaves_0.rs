impl Solution {
    pub fn num_enclaves(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        for i in 0..grid.len() {
            Self::dfs(&mut grid, i, 0);
            Self::dfs(&mut grid, i, grid[0].len() - 1);
        }
        for j in 0..grid[0].len() {
            Self::dfs(&mut grid, 0, j);
            Self::dfs(&mut grid, grid.len() - 1, j);
        }
        let mut count = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 {
                    count += 1;
                }
            }
        }
        count
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) {
        if i >= grid.len() || j >= grid[0].len() || i == 0 || j == 0 || grid[i][j] != 1 {
            return;
        }
        grid[i][j] = 0;
        Self::dfs(grid, i - 1, j);
        Self::dfs(grid, i + 1, j);
        Self::dfs(grid, i, j - 1);
        Self::dfs(grid, i, j + 1);
    }
}