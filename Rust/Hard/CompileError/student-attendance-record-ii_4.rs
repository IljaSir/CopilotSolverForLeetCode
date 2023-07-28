impl Solution {
    pub fn check_record(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![vec![0; 3]; 2]; n+1];
        dp[0][0][0] = 1;
        let mod_num = 1_000_000_007;
        for i in 1..=n {
            for absent in 0..=1 {
                for late in 0..=2 {
                    dp[i][absent][0] = (dp[i][absent][0] + dp[i-1][absent][late]) % mod_num;
                    if absent == 0 {
                        dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][late]) % mod_num;
                    }
                    if late < 2 {
                        dp[i][absent][late+1] = (dp[i][absent][late+1] + dp[i-1][absent][late]) % mod_num;
                    }
                }
            }
        }
        (dp[n][0][0] + dp[n][1][0]) % mod_num
    }
}