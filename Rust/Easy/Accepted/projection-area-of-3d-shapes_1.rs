impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut area = 0;
        let n = grid.len();
        for i in 0..n {
            let mut max_row = 0;
            let mut max_col = 0;
            for j in 0..n {
                if grid[i][j] > 0 {
                    area += 1;
                }
                max_row = max_row.max(grid[i][j]);
                max_col = max_col.max(grid[j][i]);
            }
            area += max_row + max_col;
        }
        area
    }
}