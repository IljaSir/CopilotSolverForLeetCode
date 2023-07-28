impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut top = 0;
        let mut front = 0;
        let mut side = 0;
        let mut max = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    top += 1;
                }
                if grid[i][j] > max {
                    max = grid[i][j];
                }
            }
            front += max;
            max = 0;
        }
        for i in 0..grid[0].len() {
            for j in 0..grid.len() {
                if grid[j][i] > max {
                    max = grid[j][i];
                }
            }
            side += max;
            max = 0;
        }
        top + front + side
    }
}