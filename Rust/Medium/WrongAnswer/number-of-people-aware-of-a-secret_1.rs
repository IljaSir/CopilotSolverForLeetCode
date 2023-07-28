impl Solution {
    pub fn people_aware_of_secret(n: i32, delay: i32, forget: i32) -> i32 {
        
        let n = n as usize;
        let delay = delay as usize;
        let forget = forget as usize;
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        let m = 1_000_000_007;
        for i in 1..=n {
            dp[i] = dp[i - 1] * 2 % m;
            if i >= delay {
                dp[i] = (dp[i] + m - dp[i - delay]) % m;
            }
            if i >= forget + 1 {
                dp[i] = (dp[i] + m - dp[i - forget - 1]) % m;
            }
        }
        dp[n]
    }
}