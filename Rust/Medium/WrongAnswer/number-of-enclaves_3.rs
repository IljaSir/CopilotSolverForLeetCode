impl Solution {
    pub fn num_enclaves(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    ans += Self::dfs(&mut grid, i, j);
                }
            }
        }
        ans
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> i32 {
        let m = grid.len();
        let n = grid[0].len();
        if i >= m || j >= n || i == 0 || j == 0 {
            return 0;
        }
        if grid[i][j] == 0 {
            return 1;
        }
        grid[i][j] = 0;
        let mut res = 1;
        res += Self::dfs(grid, i - 1, j);
        res += Self::dfs(grid, i + 1, j);
        res += Self::dfs(grid, i, j - 1);
        res += Self::dfs(grid, i, j + 1);
        res
    }
}