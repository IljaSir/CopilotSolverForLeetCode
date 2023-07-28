impl Solution {
    pub fn max_sum(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max = std::i32::MIN;
        let (m, n) = (grid.len(), grid[0].len());
        for i in 0..m {
            for j in 0..n {
                if i + 2 < m && j + 2 < n {
                    let sum = grid[i][j] + grid[i][j+1] + grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                    if sum > max {
                        max = sum;
                    }
                }
            }
        }
        max
    }
}