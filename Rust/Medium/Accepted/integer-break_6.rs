impl Solution {
    pub fn integer_break(n: i32) -> i32 {
        

        let n = n as usize;
        let mut dp = vec![0; n + 1];
        for i in 1..=n {
            for j in 1..i {
                dp[i] = dp[i].max(j * dp[i - j]);
                dp[i] = dp[i].max(j * (i - j));
            }
        }
        dp[n] as i32
    }
}