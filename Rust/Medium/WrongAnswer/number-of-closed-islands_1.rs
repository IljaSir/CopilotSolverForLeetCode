impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut count = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
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
        if i == 0 || j == 0 || i == grid.len() - 1 || j == grid[0].len() - 1 {
            return false;
        }
        if grid[i][j] == 1 {
            return true;
        }
        grid[i][j] = 1;
        let mut res = true;
        for &(x, y) in &[(0, 1), (1, 0), (-1, 0), (0, -1)] {
            res = res && Self::dfs(grid, (i as i32 + x) as usize, (j as i32 + y) as usize);
        }
        res
    }
}