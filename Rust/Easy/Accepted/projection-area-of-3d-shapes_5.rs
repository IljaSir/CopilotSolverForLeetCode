impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut max_row = vec![0; grid.len()];
        let mut max_col = vec![0; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                if grid[i][j] > 0 {
                    res += 1;
                }
                max_row[i] = max_row[i].max(grid[i][j]);
                max_col[j] = max_col[j].max(grid[i][j]);
            }
        }
        res + max_row.iter().sum::<i32>() + max_col.iter().sum::<i32>()
    }
}