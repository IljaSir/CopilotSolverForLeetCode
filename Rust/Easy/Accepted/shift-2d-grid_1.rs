impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut grid = grid;
        let (m, n) = (grid.len(), grid[0].len());
        let k = (k as usize) % (m * n);
        if k == 0 {
            return grid;
        }
        let mut v = Vec::with_capacity(m * n);
        for i in 0..m {
            for j in 0..n {
                v.push(grid[i][j]);
            }
        }
        v.rotate_right(k);
        for i in 0..m {
            for j in 0..n {
                grid[i][j] = v[i * n + j];
            }
        }
        grid
    }
}