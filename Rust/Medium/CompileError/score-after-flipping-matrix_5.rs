impl Solution {
    pub fn matrix_score(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let mut res = m * (1 << (n - 1));
        for j in 1..n {
            let mut n_ones = 0;
            for i in 0..m {
                if grid[i][0] == 1 {
                    n_ones += grid[i][j];
                } else {
                    n_ones += 1 - grid[i][j];
                }
            }
            let k = n_ones.max(m - n_ones);
            res += k * (1 << (n - j - 1));
        }
        res as i32
    }
}