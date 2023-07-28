impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        

        let mut num = 0;
        let mut grid = grid;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == '1' {
                    num += 1;
                    Self::dfs(&mut grid, i, j);
                }
            }
        }
        num
    }
    fn dfs(grid: &mut Vec<Vec<char>>, i: usize, j: usize) {
        if i >= grid.len() || j >= grid[i].len() || grid[i][j] != '1' {
            return;
        }
        grid[i][j] = '0';
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