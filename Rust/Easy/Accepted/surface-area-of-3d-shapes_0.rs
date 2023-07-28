impl Solution {
    pub fn surface_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let n = grid.len();
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] > 0 {
                    ans += grid[i][j] * 4 + 2;
                }
                if i > 0 {
                    ans -= (grid[i][j].min(grid[i - 1][j])) * 2;
                }
                if j > 0 {
                    ans -= (grid[i][j].min(grid[i][j - 1])) * 2;
                }
            }
        }
        ans
    }
}