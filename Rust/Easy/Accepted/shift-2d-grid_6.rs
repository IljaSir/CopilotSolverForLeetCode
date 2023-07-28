impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let k = k as usize;
        let mut temp = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let idx = (i * n + j + k) % (m * n);
                temp[idx / n][idx % n] = grid[i][j];
            }
        }
        temp
    }
}