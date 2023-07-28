impl Solution {
    pub fn max_increase_keeping_skyline(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut row_max = vec![0; grid.len()];
        let mut col_max = vec![0; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                row_max[i] = std::cmp::max(row_max[i], grid[i][j]);
                col_max[j] = std::cmp::max(col_max[j], grid[i][j]);
            }
        }
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                res += std::cmp::min(row_max[i], col_max[j]) - grid[i][j];
            }
        }
        res
    }
}