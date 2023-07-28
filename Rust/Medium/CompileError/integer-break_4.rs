impl Solution {
    pub fn integer_break(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        dp[1] = 1;
        for i in 2..=n as usize {
            for j in 1..i {
                dp[i] = std::cmp::max(dp[i], std::cmp::max(j * (i - j), j * dp[i - j]));
            }
        }
        dp[n as usize]
    }
}