impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut result = 0;
        while !grid.is_empty() {
            let mut max = 0;
            let mut max_index = 0;
            for (i, row) in grid.iter().enumerate() {
                if let Some(&m) = row.iter().max() {
                    if m > max {
                        max = m;
                        max_index = i;
                    }
                }
            }
            result += max;
            grid.remove(max_index);
        }
        result
    }
}