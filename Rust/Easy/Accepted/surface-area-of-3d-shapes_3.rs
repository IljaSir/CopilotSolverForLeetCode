impl Solution {
    pub fn surface_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut area = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    area += 2 + 4 * grid[i][j];
                }
                if i > 0 {
                    area -= 2 * std::cmp::min(grid[i][j], grid[i - 1][j]);
                }
                if j > 0 {
                    area -= 2 * std::cmp::min(grid[i][j], grid[i][j - 1]);
                }
            }
        }
        area
    }
}