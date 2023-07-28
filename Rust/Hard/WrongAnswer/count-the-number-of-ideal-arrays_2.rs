impl Solution {
    pub fn ideal_arrays(n: i32, max_value: i32) -> i32 {
        
        let n = n as usize;
        let max_value = max_value as usize;
        let mut dp = vec![vec![0; n + 1]; max_value + 1];
        let mut sum = vec![vec![0; n + 1]; max_value + 1];
        for i in 1..=max_value {
            dp[i][1] = 1;
            sum[i][1] = 1;
        }
        for i in 1..=max_value {
            for j in 2..=n {
                for k in 1..=i {
                    if i % k == 0 {
                        dp[i][j] = (dp[i][j] + sum[k][j - 1]) % 1000000007;
                    }
                }
                sum[i][j] = (sum[i][j - 1] + dp[i][j]) % 1000000007;
            }
        }
        let mut ans = 0;
        for i in 1..=max_value {
            ans = (ans + dp[i][n]) % 1000000007;
        }
        ans
    }
}