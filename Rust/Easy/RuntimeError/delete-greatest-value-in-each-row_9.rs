impl Solution {
    pub fn delete_greatest_value(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut max = 0;
        while !grid.is_empty() {
            let mut max_i = 0;
            for i in 0..grid.len() {
                let mut max_j = 0;
                for j in 0..grid[i].len() {
                    if grid[i][j] > grid[max_i][max_j] {
                        max_i = i;
                        max_j = j;
                    }
                }
                max += grid[max_i][max_j];
                grid[max_i].remove(max_j);
            }
            grid.retain(|v| !v.is_empty());
        }
        max
    }
}