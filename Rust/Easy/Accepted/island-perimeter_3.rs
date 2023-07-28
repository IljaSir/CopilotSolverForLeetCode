impl Solution {
    pub fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut sum = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    sum += 4;
                    if i > 0 && grid[i-1][j] == 1 {
                        sum -= 2;
                    }
                    if j > 0 && grid[i][j-1] == 1 {
                        sum -= 2;
                    }
                }
            }
        }
        sum
    }
}