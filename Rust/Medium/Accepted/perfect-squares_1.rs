impl Solution {
    pub fn num_squares(n: i32) -> i32 {
        

        let n = n as usize;
        let mut dp = vec![0; n+1];
        for i in 1..=n {
            dp[i] = i;
            let mut j = 1;
            while j * j <= i {
                dp[i] = std::cmp::min(dp[i], dp[i - j * j] + 1);
                j += 1;
            }
        }
        dp[n] as i32
    }
}