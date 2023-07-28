impl Solution {
    pub fn num_enclaves(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut q = Vec::new();
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if (i == 0 || i == grid.len() - 1 || j == 0 || j == grid[i].len() - 1) && grid[i][j] == 1 {
                    q.push((i, j));
                }
            }
        }
        while !q.is_empty() {
            let (i, j) = q.pop().unwrap();
            if grid[i][j] == 1 {
                grid[i][j] = 0;
                if i > 0 {
                    q.push((i - 1, j));
                }
                if i < grid.len() - 1 {
                    q.push((i + 1, j));
                }
                if j > 0 {
                    q.push((i, j - 1));
                }
                if j < grid[i].len() - 1 {
                    q.push((i, j + 1));
                }
            }
        }
        let mut ans = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    ans += 1;
                }
            }
        }
        ans
    }
}