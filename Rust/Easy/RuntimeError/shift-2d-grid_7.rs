impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut grid = grid;
        let mut k = k;
        let m = grid.len();
        let n = grid[0].len();
        while k > 0 {
            let mut i = m - 1;
            let mut j = n - 1;
            let mut prev = grid[i][j];
            while i >= 0 {
                while j >= 0 {
                    let tmp = grid[i][j];
                    grid[i][j] = prev;
                    prev = tmp;
                    j -= 1;
                }
                j = n - 1;
                i -= 1;
            }
            k -= 1;
        }
        grid
    }
}