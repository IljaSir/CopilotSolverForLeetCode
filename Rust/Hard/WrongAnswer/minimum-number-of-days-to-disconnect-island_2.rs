impl Solution {
    pub fn min_days(grid: Vec<Vec<i32>>) -> i32 {
        
        if grid.len() == 1 && grid[0].len() == 1 {
            return 0;
        }
        let mut grid = grid;
        let mut count = 0;
        let mut island = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 {
                    island += 1;
                    if i > 0 && grid[i-1][j] == 1 {
                        count += 1;
                    }
                    if j > 0 && grid[i][j-1] == 1 {
                        count += 1;
                    }
                }
            }
        }
        if island == 1 {
            return 1;
        }
        if count == 2 {
            return 0;
        }
        2
    }
}