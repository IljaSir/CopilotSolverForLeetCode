impl Solution {
    pub fn surface_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut sum = 0;
        let n = grid.len();
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] > 0 {
                    sum += 2 + 4 * grid[i][j];
                    if i > 0 {
                        sum -= 2 * grid[i][j].min(grid[i - 1][j]);
                    }
                    if j > 0 {
                        sum -= 2 * grid[i][j].min(grid[i][j - 1]);
                    }
                }
            }
        }
        sum
    }
}