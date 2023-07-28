impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut rotten = Vec::new();
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 2 {
                    rotten.push((i, j));
                }
            }
        }
        let mut minutes = 0;
        while !rotten.is_empty() {
            let mut new_rotten = Vec::new();
            for (i, j) in rotten {
                if i > 0 && grid[i - 1][j] == 1 {
                    grid[i - 1][j] = 2;
                    new_rotten.push((i - 1, j));
                }
                if i < grid.len() - 1 && grid[i + 1][j] == 1 {
                    grid[i + 1][j] = 2;
                    new_rotten.push((i + 1, j));
                }
                if j > 0 && grid[i][j - 1] == 1 {
                    grid[i][j - 1] = 2;
                    new_rotten.push((i, j - 1));
                }
                if j < grid[i].len() - 1 && grid[i][j + 1] == 1 {
                    grid[i][j + 1] = 2;
                    new_rotten.push((i, j + 1));
                }
            }
            rotten = new_rotten;
            minutes += 1;
        }
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    return -1;
                }
            }
        }
        if minutes > 0 {
            minutes - 1
        } else {
            0
        }
    }
}