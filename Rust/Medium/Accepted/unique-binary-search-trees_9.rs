impl Solution {
    pub fn num_trees(n: i32) -> i32 {
        

        if n == 1 {
            return 1;
        }
        let mut dp = vec![0; (n + 1) as usize];
        dp[0] = 1;
        dp[1] = 1;
        for i in 2..=n {
            for j in 1..=i {
                dp[i as usize] += dp[(j - 1) as usize] * dp[(i - j) as usize];
            }
        }
        dp[n as usize]
    }
}