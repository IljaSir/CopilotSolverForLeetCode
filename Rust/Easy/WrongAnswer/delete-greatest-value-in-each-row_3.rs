impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 0;
        let mut grid = grid;
        while grid.len() > 0 {
            let mut max = 0;
            let mut max_index = 0;
            for i in 0..grid.len() {
                let row = &grid[i];
                for j in 0..row.len() {
                    let value = row[j];
                    if value > max {
                        max = value;
                        max_index = j;
                    }
                }
            }
            result += max;
            for i in 0..grid.len() {
                grid[i].remove(max_index);
            }
            grid.retain(|row| row.len() > 0);
        }
        result
    }
}