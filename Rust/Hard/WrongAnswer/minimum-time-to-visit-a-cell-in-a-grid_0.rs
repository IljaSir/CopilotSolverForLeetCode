impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let m = grid[0].len();
        let mut dp = vec![vec![std::i32::MAX; m]; n];
        dp[0][0] = 0;
        let mut q = std::collections::BinaryHeap::new();
        q.push((0, 0, 0));
        while let Some((t, i, j)) = q.pop() {
            let t = -t;
            if i == n - 1 && j == m - 1 {
                return t;
            }
            if i > 0 {
                let t2 = std::cmp::max(t, grid[i - 1][j]);
                if t2 < dp[i - 1][j] {
                    dp[i - 1][j] = t2;
                    q.push((-(t2 as i32), i - 1, j));
                }
            }
            if i + 1 < n {
                let t2 = std::cmp::max(t, grid[i + 1][j]);
                if t2 < dp[i + 1][j] {
                    dp[i + 1][j] = t2;
                    q.push((-(t2 as i32), i + 1, j));
                }
            }
            if j > 0 {
                let t2 = std::cmp::max(t, grid[i][j - 1]);
                if t2 < dp[i][j - 1] {
                    dp[i][j - 1] = t2;
                    q.push((-(t2 as i32), i, j - 1));
                }
            }
            if j + 1 < m {
                let t2 = std::cmp::max(t, grid[i][j + 1]);
                if t2 < dp[i][j + 1] {
                    dp[i][j + 1] = t2;
                    q.push((-(t2 as i32), i, j + 1));
                }
            }
        }
        -1
    }
}