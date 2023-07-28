impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut result = 0;
        while !grid.is_empty() {
            let mut max = 0;
            for i in 0..grid.len() {
                let mut max_i = 0;
                for j in 0..grid[i].len() {
                    if grid[i][j] > grid[i][max_i] {
                        max_i = j;
                    }
                }
                result += grid[i][max_i];
                grid[i].remove(max_i);
                if grid[i].is_empty() {
                    max = i;
                }
            }
            grid.remove(max);
        }
        result
    }
}