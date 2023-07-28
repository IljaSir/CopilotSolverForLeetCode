impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut maxs = vec![0; grid.len()];
        for i in 0..grid.len() {
            max = 0;
            for j in 0..grid[i].len() {
                if grid[i][j] > 0 {
                    count += 1;
                }
                if grid[i][j] > max {
                    max = grid[i][j];
                }
                if grid[i][j] > maxs[j] {
                    maxs[j] = grid[i][j];
                }
            }
            count += max;
        }
        for i in 0..maxs.len() {
            count += maxs[i];
        }
        count
    }
}