impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut xy = 0;
        let mut xz = 0;
        let mut yz = 0;
        for i in 0..grid.len() {
            let mut max = 0;
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    xy += 1;
                }
                if grid[i][j] > max {
                    max = grid[i][j];
                }
            }
            xz += max;
        }
        for j in 0..grid[0].len() {
            let mut max = 0;
            for i in 0..grid.len() {
                if grid[i][j] > max {
                    max = grid[i][j];
                }
            }
            yz += max;
        }
        xy + xz + yz
    }
}