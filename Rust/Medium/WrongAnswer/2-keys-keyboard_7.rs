impl Solution {
    pub fn min_steps(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 2..=n {
            let mut j = 2;
            while j * j <= i {
                if i % j == 0 {
                    dp[i as usize] = dp[j as usize] + i / j;
                    break;
                }
                j += 1;
            }
            if dp[i as usize] == 0 {
                dp[i as usize] = i;
            }
        }
        dp[n as usize]
    }
}