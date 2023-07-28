impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut total = 0;
        for i in 0..grid.len() {
            let mut max_row = 0;
            let mut max_col = 0;
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    total += 1;
                }
                if grid[i][j] > max_row {
                    max_row = grid[i][j];
                }
                if grid[j][i] > max_col {
                    max_col = grid[j][i];
                }
            }
            total += max_row + max_col;
        }
        total
    }
}