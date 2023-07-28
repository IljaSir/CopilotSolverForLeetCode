impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut sum = 0;
        while !grid.is_empty() {
            let mut max = 0;
            let mut max_i = 0;
            for (i, row) in grid.iter().enumerate() {
                if let Some(&v) = row.iter().max() {
                    if v > max {
                        max = v;
                        max_i = i;
                    }
                }
            }
            sum += max;
            grid.remove(max_i);
        }
        sum
    }
}