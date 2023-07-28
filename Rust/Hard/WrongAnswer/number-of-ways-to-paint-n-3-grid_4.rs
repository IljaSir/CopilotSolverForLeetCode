impl Solution {
    pub fn num_of_ways(n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 3]; n as usize + 1];
        for i in 0..3 {
            dp[0][i] = 1;
        }
        for i in 1..(n as usize + 1) {
            for j in 0..3 {
                for k in 0..3 {
                    if j != k {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        let mut ans = 0;
        for i in 0..3 {
            ans += dp[n as usize][i];
            ans %= 1000000007;
        }
        ans
    }
}