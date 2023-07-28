impl Solution {
    pub fn surface_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut area = 0;
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                if grid[i][j] > 0 {
                    area += grid[i][j] * 4 + 2;
                }
                if i > 0 {
                    area -= std::cmp::min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if j > 0 {
                    area -= std::cmp::min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        area
    }
}