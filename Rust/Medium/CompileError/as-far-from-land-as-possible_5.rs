impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut q = std::collections::VecDeque::new();
        let mut n = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    q.push_back((i, j));
                    n += 1;
                }
            }
        }
        if n == 0 || n == grid.len() * grid[0].len() {
            return -1;
        }
        let mut ans = -1;
        while let Some((i, j)) = q.pop_front() {
            ans += 1;
            if i > 0 && grid[i - 1][j] == 0 {
                grid[i - 1][j] = 1;
                q.push_back((i - 1, j));
            }
            if i + 1 < grid.len() && grid[i + 1][j] == 0 {
                grid[i + 1][j] = 1;
                q.push_back((i + 1, j));
            }
            if j > 0 && grid[i][j - 1] == 0 {
                grid[i][j - 1] = 1;
                q.push_back((i, j - 1));
            }
            if j + 1 < grid[i].len() && grid[i][j + 1] == 0 {
                grid[i][j + 1] = 1;
                q.push_back((i, j + 1));
            }
        }
        ans
    }
}