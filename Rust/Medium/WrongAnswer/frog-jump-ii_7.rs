impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let n = stones.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = stones[i];
        }
        for i in 0..n {
            for j in 0..n {
                if i < j {
                    dp[i][j] = dp[i][j - 1].max(stones[j] - stones[j - 1]);
                } else if i > j {
                    dp[i][j] = dp[i][j + 1].max(stones[j + 1] - stones[j]);
                }
            }
        }
        let mut ans = 0;
        for i in 0..n {
            ans = ans.max(dp[i][n - 1]);
        }
        ans
    }
}