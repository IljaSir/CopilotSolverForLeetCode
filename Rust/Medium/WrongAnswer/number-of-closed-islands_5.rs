impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut cnt = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 0 {
                    if Self::dfs(&mut grid, i, j) {
                        cnt += 1;
                    }
                }
            }
        }
        cnt
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> bool {
        if i == 0 || i == grid.len() - 1 || j == 0 || j == grid[0].len() - 1 {
            return false;
        }
        if grid[i][j] == 1 {
            return true;
        }
        grid[i][j] = 1;
        let mut ret = true;
        if i > 0 {
            ret &= Self::dfs(grid, i - 1, j);
        }
        if i < grid.len() - 1 {
            ret &= Self::dfs(grid, i + 1, j);
        }
        if j > 0 {
            ret &= Self::dfs(grid, i, j - 1);
        }
        if j < grid[0].len() - 1 {
            ret &= Self::dfs(grid, i, j + 1);
        }
        ret
    }
}