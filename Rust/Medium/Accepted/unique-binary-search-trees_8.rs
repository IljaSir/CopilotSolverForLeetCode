impl Solution {
    pub fn num_trees(n: i32) -> i32 {
        

        let mut dp = vec![0; (n + 1) as usize];
        dp[0] = 1;
        for i in 1..=n as usize {
            for j in 0..i {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        dp[n as usize]
    }
}