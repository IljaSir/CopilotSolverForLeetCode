impl Solution {
    pub fn num_of_ways(n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 3]; 2];
        dp[0][0] = 6;
        dp[0][1] = 6;
        dp[0][2] = 6;
        for i in 1..n as usize {
            dp[i % 2][0] = (dp[(i - 1) % 2][1] + dp[(i - 1) % 2][2]) % 1000000007;
            dp[i % 2][1] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][2]) % 1000000007;
            dp[i % 2][2] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1]) % 1000000007;
        }
        let ans = (dp[(n - 1) as usize % 2][0] + dp[(n - 1) as usize % 2][1] + dp[(n - 1) as usize % 2][2]) % 1000000007;
        ans as i32
    }
}