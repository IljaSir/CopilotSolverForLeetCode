impl Solution {
    pub fn surface_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 0;
        let n = grid.len();
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] > 0 {
                    result += 2;
                    result += 4 * grid[i][j];
                    if i > 0 {
                        result -= 2 * grid[i-1][j].min(grid[i][j]);
                    }
                    if j > 0 {
                        result -= 2 * grid[i][j-1].min(grid[i][j]);
                    }
                }
            }
        }
        result
    }
}