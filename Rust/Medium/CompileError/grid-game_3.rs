impl Solution {
    pub fn grid_game(grid: Vec<Vec<i32>>) -> i64 {
        
        let n = grid[0].len();
        let mut prefix_sum = vec![vec![0; n + 1]; 2];
        for i in 0..2 {
            for j in 0..n {
                prefix_sum[i][j + 1] = prefix_sum[i][j] + grid[i][j];
            }
        }
        let mut min = std::i64::MAX;
        let mut sum = 0;
        for i in 0..n {
            sum += grid[1][i];
        }
        for i in 0..n {
            sum -= grid[1][i];
            min = min.min(sum);
            sum += grid[0][i];
        }
        min as i64
    }
}