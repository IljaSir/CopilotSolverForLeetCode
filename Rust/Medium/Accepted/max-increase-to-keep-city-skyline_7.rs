impl Solution {
    pub fn max_increase_keeping_skyline(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut top: Vec<i32> = vec![];
        let mut left: Vec<i32> = vec![];
        for i in 0..grid.len() {
            let mut max_top = 0;
            let mut max_left = 0;
            for j in 0..grid.len() {
                if grid[i][j] > max_top {
                    max_top = grid[i][j];
                }
                if grid[j][i] > max_left {
                    max_left = grid[j][i];
                }
            }
            top.push(max_top);
            left.push(max_left);
        }
        let mut sum = 0;
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                let min = std::cmp::min(top[i], left[j]);
                sum += min - grid[i][j];
            }
        }
        sum
    }
}