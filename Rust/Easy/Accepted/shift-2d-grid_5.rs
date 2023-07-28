impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut grid = grid;
        let (m, n) = (grid.len(), grid[0].len());
        for _ in 0..k {
            let mut temp = vec![vec![0; n]; m];
            for i in 0..m {
                for j in 0..n {
                    if j < n - 1 {
                        temp[i][j + 1] = grid[i][j];
                    } else {
                        temp[(i + 1) % m][0] = grid[i][j];
                    }
                }
            }
            grid = temp;
        }
        grid
    }
}