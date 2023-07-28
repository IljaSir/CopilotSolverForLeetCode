impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut sum = 0;
        while !grid.is_empty() {
            let mut max = 0;
            let mut max_row = 0;
            let mut max_col = 0;
            for (row, row_value) in grid.iter().enumerate() {
                for (col, col_value) in row_value.iter().enumerate() {
                    if *col_value > max {
                        max = *col_value;
                        max_row = row;
                        max_col = col;
                    }
                }
            }
            sum += max;
            grid[max_row].remove(max_col);
            if grid[max_row].is_empty() {
                grid.remove(max_row);
            }
        }
        sum
    }
}