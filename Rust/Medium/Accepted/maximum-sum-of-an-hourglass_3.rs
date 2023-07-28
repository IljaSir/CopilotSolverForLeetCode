impl Solution {
    pub fn max_sum(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max = i32::MIN;
        for i in 0..grid.len() - 2 {
            for j in 0..grid[0].len() - 2 {
                let sum = grid[i][j] + grid[i][j+1] + grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                if sum > max {
                    max = sum;
                }
            }
        }
        max
    }
}