impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut last = 0;
        let mut count = 0;
        loop {
            last = 0;
            let mut fresh = 0;
            for i in 0..grid.len() {
                for j in 0..grid[i].len() {
                    if grid[i][j] == 2 {
                        if i > 0 && grid[i-1][j] == 1 {
                            grid[i-1][j] = 3;
                            last = 1;
                        }
                        if i < grid.len()-1 && grid[i+1][j] == 1 {
                            grid[i+1][j] = 3;
                            last = 1;
                        }
                        if j > 0 && grid[i][j-1] == 1 {
                            grid[i][j-1] = 3;
                            last = 1;
                        }
                        if j < grid[i].len()-1 && grid[i][j+1] == 1 {
                            grid[i][j+1] = 3;
                            last = 1;
                        }
                    }
                    if grid[i][j] == 1 {
                        fresh += 1;
                    }
                }
            }
            for i in 0..grid.len() {
                for j in 0..grid[i].len() {
                    if grid[i][j] == 3 {
                        grid[i][j] = 2;
                    }
                }
            }
            if fresh == 0 {
                return count;
            }
            if last == 0 {
                return -1;
            }
            count += 1;
        }
    }
}