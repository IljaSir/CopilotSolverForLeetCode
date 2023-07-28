impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut count = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 0 {
                    if Self::dfs(&mut grid, i, j) {
                        count += 1;
                    }
                }
            }
        }
        count
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> bool {
        if i == 0 || i == grid.len() - 1 || j == 0 || j == grid[i].len() - 1 {
            return false;
        }
        if grid[i][j] == 1 {
            return true;
        }
        grid[i][j] = 1;
        let mut result = true;
        if i > 0 {
            result = result && Self::dfs(grid, i - 1, j);
        }
        if i < grid.len() - 1 {
            result = result && Self::dfs(grid, i + 1, j);
        }
        if j > 0 {
            result = result && Self::dfs(grid, i, j - 1);
        }
        if j < grid[i].len() - 1 {
            result = result && Self::dfs(grid, i, j + 1);
        }
        result
    }
}