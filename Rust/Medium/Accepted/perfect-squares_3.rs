impl Solution {
    pub fn num_squares(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 1..=n {
            dp[i as usize] = i;
            let mut j = 1;
            while i - j * j >= 0 {
                dp[i as usize] = dp[i as usize].min(dp[(i - j * j) as usize] + 1);
                j += 1;
            }
        }
        dp[n as usize]
    }
}