impl Solution {
    pub fn color_the_grid(m: i32, n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 3]; n as usize];
        for i in 0..3 {
            dp[0][i] = 1;
        }
        for i in 1..n as usize {
            for j in 0..3 {
                for k in 0..3 {
                    if j != k {
                        dp[i][j] = (dp[i][j] + dp[i-1][k]) % 1000000007;
                    }
                }
            }
        }
        let mut ans = 0;
        for i in 0..3 {
            ans = (ans + dp[n as usize - 1][i]) % 1000000007;
        }
        for _ in 1..m {
            ans = (ans * ans) % 1000000007;
        }
        ans
    }
}