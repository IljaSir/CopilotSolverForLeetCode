impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut q = Vec::new();
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] == 1 {
                    q.push((i, j));
                }
            }
        }
        if q.len() == 0 || q.len() == n * n {
            return -1;
        }
        let mut res = 0;
        while !q.is_empty() {
            let mut t = Vec::new();
            for (i, j) in q {
                if i > 0 && grid[i - 1][j] == 0 {
                    grid[i - 1][j] = 1;
                    t.push((i - 1, j));
                }
                if i < n - 1 && grid[i + 1][j] == 0 {
                    grid[i + 1][j] = 1;
                    t.push((i + 1, j));
                }
                if j > 0 && grid[i][j - 1] == 0 {
                    grid[i][j - 1] = 1;
                    t.push((i, j - 1));
                }
                if j < n - 1 && grid[i][j + 1] == 0 {
                    grid[i][j + 1] = 1;
                    t.push((i, j + 1));
                }
            }
            q = t;
            res += 1;
        }
        res - 1
    }
}