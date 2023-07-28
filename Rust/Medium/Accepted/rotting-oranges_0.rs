impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut queue = Vec::new();
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 2 {
                    queue.push((i, j));
                }
            }
        }
        let mut step = 0;
        while !queue.is_empty() {
            let mut next_queue = Vec::new();
            for (i, j) in queue {
                if i > 0 && grid[i-1][j] == 1 {
                    grid[i-1][j] = 2;
                    next_queue.push((i-1, j));
                }
                if i < grid.len()-1 && grid[i+1][j] == 1 {
                    grid[i+1][j] = 2;
                    next_queue.push((i+1, j));
                }
                if j > 0 && grid[i][j-1] == 1 {
                    grid[i][j-1] = 2;
                    next_queue.push((i, j-1));
                }
                if j < grid[0].len()-1 && grid[i][j+1] == 1 {
                    grid[i][j+1] = 2;
                    next_queue.push((i, j+1));
                }
            }
            queue = next_queue;
            if !queue.is_empty() {
                step += 1;
            }
        }
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 {
                    return -1;
                }
            }
        }
        step
    }
}