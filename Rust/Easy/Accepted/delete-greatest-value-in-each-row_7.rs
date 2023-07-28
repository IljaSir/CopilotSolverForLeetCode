impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut ans = 0;
        while grid.len() > 0 {
            let mut max = 0;
            for i in 0..grid.len() {
                let mut max_row = 0;
                for j in 0..grid[i].len() {
                    if grid[i][j] > max_row {
                        max_row = grid[i][j];
                    }
                }
                if max_row > max {
                    max = max_row;
                }
            }
            ans += max;
            for i in 0..grid.len() {
                let mut max_row = 0;
                let mut index = 0;
                for j in 0..grid[i].len() {
                    if grid[i][j] > max_row {
                        max_row = grid[i][j];
                        index = j;
                    }
                }
                grid[i].remove(index);
            }
            grid.retain(|row| row.len() > 0);
        }
        ans
    }
}