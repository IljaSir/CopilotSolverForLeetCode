impl Solution {
    pub fn min_steps(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 2..=n {
            let mut j = i - 1;
            while j > 0 {
                if i % j == 0 {
                    dp[i as usize] = dp[j as usize] + i / j;
                    break;
                }
                j -= 1;
            }
        }
        dp[n as usize]
    }
}