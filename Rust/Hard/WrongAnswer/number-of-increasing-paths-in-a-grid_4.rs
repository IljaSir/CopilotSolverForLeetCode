impl Solution {
    pub fn count_paths(grid: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (grid.len(), grid[0].len());
        let mut dp = vec![vec![0; n]; m];
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                for (di, dj) in vec![(-1, 0), (1, 0), (0, -1), (0, 1)] {
                    let (ni, nj) = (i as i32 + di, j as i32 + dj);
                    if ni >= 0 && ni < m as i32 && nj >= 0 && nj < n as i32 && grid[ni as usize][nj as usize] > grid[i][j] {
                        dp[i][j] += dp[ni as usize][nj as usize];
                    }
                }
                if dp[i][j] == 0 {
                    dp[i][j] = 1;
                }
                ans += dp[i][j];
                ans %= 1_000_000_007;
            }
        }
        ans
    }
}