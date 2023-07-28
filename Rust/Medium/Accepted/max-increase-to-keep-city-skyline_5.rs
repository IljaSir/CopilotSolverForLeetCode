impl Solution {
    pub fn max_increase_keeping_skyline(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let m = grid.len();
        let n = grid[0].len();
        let mut row = vec![0; m];
        let mut col = vec![0; n];
        for i in 0..m {
            for j in 0..n {
                row[i] = row[i].max(grid[i][j]);
                col[j] = col[j].max(grid[i][j]);
            }
        }
        for i in 0..m {
            for j in 0..n {
                ans += row[i].min(col[j]) - grid[i][j];
            }
        }
        ans
    }
}