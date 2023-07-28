impl Solution {
    pub fn stone_game_vii(stones: Vec<i32>) -> i32 {
        
        let n = stones.len();
        let mut dp = vec![vec![0; n]; n];
        let mut pre = vec![0; n + 1];
        for i in 0..n {
            pre[i + 1] = pre[i] + stones[i];
        }
        for i in (0..n).rev() {
            for j in i + 1..n {
                dp[i][j] = pre[j + 1] - pre[i + 1] - dp[i + 1][j];
                dp[i][j] = dp[i][j].max(pre[j] - pre[i] - dp[i][j - 1]);
            }
        }
        dp[0][n - 1]
    }
}