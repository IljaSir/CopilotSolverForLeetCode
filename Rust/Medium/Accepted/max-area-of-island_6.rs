impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let (m, n) = (grid.len(), grid[0].len());
        let mut grid = grid;
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    ans = ans.max(Solution::dfs(&mut grid, i, j, m, n));
                }
            }
        }
        ans
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, x: usize, y: usize, m: usize, n: usize) -> i32 {
        if x >= m || y >= n || grid[x][y] == 0 {
            return 0;
        }
        grid[x][y] = 0;
        1 + Solution::dfs(grid, x + 1, y, m, n)
            + Solution::dfs(grid, x, y + 1, m, n)
            + Solution::dfs(grid, x, y.saturating_sub(1), m, n)
            + Solution::dfs(grid, x.saturating_sub(1), y, m, n)
    }
}