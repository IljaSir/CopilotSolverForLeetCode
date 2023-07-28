impl Solution {
    pub fn surface_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    result += 2;
                    result += if i == 0 { grid[i][j] } else { grid[i][j] - grid[i - 1][j] }.max(0);
                    result += if i == grid.len() - 1 { grid[i][j] } else { grid[i][j] - grid[i + 1][j] }.max(0);
                    result += if j == 0 { grid[i][j] } else { grid[i][j] - grid[i][j - 1] }.max(0);
                    result += if j == grid[i].len() - 1 { grid[i][j] } else { grid[i][j] - grid[i][j + 1] }.max(0);
                }
            }
        }
        result
    }
}