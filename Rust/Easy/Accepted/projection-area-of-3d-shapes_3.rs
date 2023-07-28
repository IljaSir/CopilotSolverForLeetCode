impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut x = 0;
        let mut y = 0;
        let mut z = 0;
        for i in 0..grid.len() {
            let mut max = 0;
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    x += 1;
                }
                if grid[i][j] > max {
                    max = grid[i][j];
                }
            }
            y += max;
        }
        for i in 0..grid[0].len() {
            let mut max = 0;
            for j in 0..grid.len() {
                if grid[j][i] > max {
                    max = grid[j][i];
                }
            }
            z += max;
        }
        x + y + z
    }
}