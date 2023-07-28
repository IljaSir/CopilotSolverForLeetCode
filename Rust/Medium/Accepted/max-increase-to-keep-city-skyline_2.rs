impl Solution {
    pub fn max_increase_keeping_skyline(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut top = vec![0; n];
        let mut left = vec![0; n];
        for i in 0..n {
            for j in 0..n {
                top[i] = top[i].max(grid[i][j]);
                left[j] = left[j].max(grid[i][j]);
            }
        }
        let mut ans = 0;
        for i in 0..n {
            for j in 0..n {
                ans += top[i].min(left[j]) - grid[i][j];
            }
        }
        ans
    }
}