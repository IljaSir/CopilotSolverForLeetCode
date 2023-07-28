impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut top = 0;
        let mut front = 0;
        let mut side = 0;
        for i in 0..grid.len() {
            let mut max = 0;
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    top += 1;
                }
                if grid[i][j] > max {
                    max = grid[i][j];
                }
            }
            front += max;
        }
        for j in 0..grid[0].len() {
            let mut max = 0;
            for i in 0..grid.len() {
                if grid[i][j] > max {
                    max = grid[i][j];
                }
            }
            side += max;
        }
        top + front + side
    }
}