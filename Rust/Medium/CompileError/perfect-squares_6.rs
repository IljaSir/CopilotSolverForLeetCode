impl Solution {
    pub fn num_squares(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 1..=n as usize {
            dp[i] = i;
            for j in 1..=i {
                if j * j > i {
                    break;
                }
                dp[i] = dp[i].min(dp[i - j * j] + 1);
            }
        }
        dp[n as usize]
    }
}