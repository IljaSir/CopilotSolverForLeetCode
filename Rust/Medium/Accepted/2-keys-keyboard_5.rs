impl Solution {
    pub fn min_steps(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 2..=n as usize {
            dp[i] = i as i32;
            for j in (2..i).rev() {
                if i % j == 0 {
                    dp[i] = dp[j] + (i / j) as i32;
                    break;
                }
            }
        }
        dp[n as usize]
    }
}