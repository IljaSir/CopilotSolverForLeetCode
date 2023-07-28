impl Solution {
    pub fn max_taxi_earnings(n: i32, rides: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![0; n as usize + 1];
        let n = n as usize;
        for i in (0..n).rev() {
            dp[i] = dp[i + 1];
            for ride in &rides {
                if ride[0] == (i + 1) as i32 {
                    dp[i] = std::cmp::max(dp[i], (ride[1] - ride[0] + ride[2]) as i64 + dp[ride[1] as usize]);
                }
            }
        }
        dp[0]
    }
}