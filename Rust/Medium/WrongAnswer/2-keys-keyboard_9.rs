impl Solution {
    pub fn min_steps(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 2..=n {
            let mut j = 2;
            dp[i as usize] = i;
            while i * j <= n {
                if i * j == n {
                    dp[i as usize] = dp[i as usize].min(dp[j as usize] + j);
                }
                j += 1;
            }
        }
        dp[n as usize]
    }
}