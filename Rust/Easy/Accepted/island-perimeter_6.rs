impl Solution {
    pub fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 0;
        let (row, col) = (grid.len(), grid[0].len());
        for i in 0..row {
            for j in 0..col {
                if grid[i][j] == 1 {
                    result += 4;
                    if i > 0 && grid[i-1][j] == 1 {
                        result -= 2;
                    }
                    if j > 0 && grid[i][j-1] == 1 {
                        result -= 2;
                    }
                }
            }
        }
        result
    }
}