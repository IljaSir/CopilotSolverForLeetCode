impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut min = vec![vec![std::i32::MAX; grid[0].len()]; grid.len()];
        let mut max = vec![vec![std::i32::MIN; grid[0].len()]; grid.len()];
        let m: i64 = 1000000007;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if i == 0 && j == 0 {
                    min[i][j] = grid[i][j];
                    max[i][j] = grid[i][j];
                } else if i == 0 {
                    min[i][j] = grid[i][j] * min[i][j-1];
                    max[i][j] = grid[i][j] * max[i][j-1];
                } else if j == 0 {
                    min[i][j] = grid[i][j] * min[i-1][j];
                    max[i][j] = grid[i][j] * max[i-1][j];
                } else {
                    min[i][j] = std::cmp::min(grid[i][j] * min[i-1][j], grid[i][j] * min[i][j-1]);
                    min[i][j] = std::cmp::min(min[i][j], grid[i][j] * max[i-1][j]);
                    min[i][j] = std::cmp::min(min[i][j], grid[i][j] * max[i][j-1]);
                    max[i][j] = std::cmp::max(grid[i][j] * min[i-1][j], grid[i][j] * min[i][j-1]);
                    max[i][j] = std::cmp::max(max[i][j], grid[i][j] * max[i-1][j]);
                    max[i][j] = std::cmp::max(max[i][j], grid[i][j] * max[i][j-1]);
                }
            }
        }
        if min[grid.len()-1][grid[0].len()-1] < 0 {
            return -1;
        }
        (max[grid.len()-1][grid[0].len()-1] % m) as i32
    }
}