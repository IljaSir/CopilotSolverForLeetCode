impl Solution {
    pub fn max_increase_keeping_skyline(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max_row = vec![0; grid.len()];
        let mut max_col = vec![0; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                max_row[i] = max_row[i].max(grid[i][j]);
                max_col[j] = max_col[j].max(grid[i][j]);
            }
        }
        let mut sum = 0;
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                sum += max_row[i].min(max_col[j]) - grid[i][j];
            }
        }
        sum
    }
}