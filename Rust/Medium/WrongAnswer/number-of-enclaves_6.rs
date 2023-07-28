impl Solution {
    pub fn num_enclaves(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut res = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 {
                    if Self::dfs(&mut grid, i, j) {
                        res += 1;
                    }
                }
            }
        }
        res
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> bool {
        if i >= grid.len() || i < 0 || j >= grid[0].len() || j < 0 {
            return false;
        }
        if grid[i][j] == 0 {
            return true;
        }
        grid[i][j] = 0;
        let mut res = true;
        res &= Self::dfs(grid, i + 1, j);
        res &= Self::dfs(grid, i, j + 1);
        res &= Self::dfs(grid, i - 1, j);
        res &= Self::dfs(grid, i, j - 1);
        res
    }
}