impl Solution {
    pub fn num_trees(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        dp[0] = 1;
        dp[1] = 1;
        for i in 2..=n {
            for j in 0..i {
                dp[i as usize] += dp[j as usize] * dp[(i - j - 1) as usize];
            }
        }
        dp[n as usize]
    }
}