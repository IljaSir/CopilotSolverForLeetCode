impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let mut c = corridor.chars().collect::<Vec<char>>();
        let n = c.len();
        let mut dp = vec![vec![0; 3]; n];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for i in 1..n {
            if c[i] == 'S' {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000007;
                dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 1000000007;
                dp[i][2] = dp[i-1][1];
            }
        }
        dp[n-1][1]
    }
}