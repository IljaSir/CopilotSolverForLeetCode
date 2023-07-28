impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut ans = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 0 {
                    if Self::dfs(&mut grid, i, j) {
                        ans += 1;
                    }
                }
            }
        }
        ans
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> bool {
        if i == 0 || j == 0 || i == grid.len() - 1 || j == grid[i].len() - 1 {
            return false;
        }
        grid[i][j] = 1;
        let mut ans = true;
        if i > 0 && grid[i - 1][j] == 0 {
            ans &= Self::dfs(grid, i - 1, j);
        }
        if j > 0 && grid[i][j - 1] == 0 {
            ans &= Self::dfs(grid, i, j - 1);
        }
        if i < grid.len() - 1 && grid[i + 1][j] == 0 {
            ans &= Self::dfs(grid, i + 1, j);
        }
        if j < grid[i].len() - 1 && grid[i][j + 1] == 0 {
            ans &= Self::dfs(grid, i, j + 1);
        }
        ans
    }
}