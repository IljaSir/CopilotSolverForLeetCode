impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let mut k = k as usize;
        k %= m * n;
        for _ in 0..k {
            let mut tmp = grid[m - 1][n - 1];
            for i in 0..m {
                for j in 0..n {
                    let t = grid[i][j];
                    grid[i][j] = tmp;
                    tmp = t;
                }
            }
        }
        grid
    }
}