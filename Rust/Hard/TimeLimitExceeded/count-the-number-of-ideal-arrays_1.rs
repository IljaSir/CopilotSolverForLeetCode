impl Solution {
    pub fn ideal_arrays(n: i32, max_value: i32) -> i32 {
        
        let n = n as usize;
        let max_value = max_value as usize;
        let mut dp = vec![vec![0; n + 1]; max_value + 1];
        for i in 1..=max_value {
            dp[i][1] = 1;
        }
        for j in 2..=n {
            for i in 1..=max_value {
                for k in 1..=i {
                    if i % k == 0 {
                        dp[i][j] = (dp[i][j] + dp[k][j - 1]) % 1000000007;
                    }
                }
            }
        }
        let mut ans = 0;
        for i in 1..=max_value {
            ans = (ans + dp[i][n]) % 1000000007;
        }
        ans
    }
}