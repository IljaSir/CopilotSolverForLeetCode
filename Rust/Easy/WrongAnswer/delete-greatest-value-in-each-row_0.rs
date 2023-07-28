impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut result = 0;
        while !grid.is_empty() {
            let mut max = 0;
            let mut index = 0;
            for i in 0..grid.len() {
                let mut max_in_row = 0;
                for j in 0..grid[i].len() {
                    if grid[i][j] > max_in_row {
                        max_in_row = grid[i][j];
                    }
                }
                if max_in_row > max {
                    max = max_in_row;
                    index = i;
                }
            }
            result += max;
            grid.remove(index);
        }
        result
    }
}