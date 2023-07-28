impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp_max = vec![vec![0; n]; m];
        let mut dp_min = vec![vec![0; n]; m];
        dp_max[0][0] = grid[0][0];
        dp_min[0][0] = grid[0][0];
        for i in 1..m {
            dp_max[i][0] = dp_max[i-1][0] * grid[i][0];
            dp_min[i][0] = dp_min[i-1][0] * grid[i][0];
        }
        for j in 1..n {
            dp_max[0][j] = dp_max[0][j-1] * grid[0][j];
            dp_min[0][j] = dp_min[0][j-1] * grid[0][j];
        }
        for i in 1..m {
            for j in 1..n {
                dp_max[i][j] = std::cmp::max(
                    std::cmp::max(dp_max[i-1][j] * grid[i][j], dp_max[i][j-1] * grid[i][j]),
                    std::cmp::max(dp_min[i-1][j] * grid[i][j], dp_min[i][j-1] * grid[i][j])
                );
                dp_min[i][j] = std::cmp::min(
                    std::cmp::min(dp_max[i-1][j] * grid[i][j], dp_max[i][j-1] * grid[i][j]),
                    std::cmp::min(dp_min[i-1][j] * grid[i][j], dp_min[i][j-1] * grid[i][j])
                );
            }
        }
        if dp_max[m-1][n-1] < 0 {
            -1
        } else {
            (dp_max[m-1][n-1] % (1e9 as i32 + 7)) as i32
        }
    }
}