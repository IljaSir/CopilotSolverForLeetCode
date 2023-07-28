impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let (m, n) = (grid.len(), grid[0].len());
        let mut grid = grid;
        let mut k = k as usize;
        while k > 0 {
            let mut last = grid[m - 1][n - 1];
            for i in 0..m {
                for j in 0..n {
                    let tmp = grid[i][j];
                    grid[i][j] = last;
                    last = tmp;
                }
            }
            k -= 1;
        }
        grid
    }
}