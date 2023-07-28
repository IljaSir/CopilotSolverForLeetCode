impl Solution {
    pub fn rearrange_sticks(n: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let k = k as usize;
        let mut dp = vec![vec![0; k+1]; n+1];
        dp[0][0] = 1;
        let mut ans = 0;
        for i in 1..=n {
            for j in 1..=k {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j] * (i-1) as i32) % 1000000007;
            }
            ans = (ans + dp[i][k]) % 1000000007;
        }
        ans
    }
}