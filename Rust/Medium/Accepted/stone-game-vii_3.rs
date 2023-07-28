impl Solution {
    pub fn stone_game_vii(stones: Vec<i32>) -> i32 {
        
        let n = stones.len();
        let mut dp = vec![vec![0; n]; n];
        let mut sum = vec![0; n+1];
        for i in 0..n {
            sum[i+1] = sum[i] + stones[i];
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                dp[i][j] = (sum[j+1] - sum[i+1] - dp[i+1][j]).max(sum[j] - sum[i] - dp[i][j-1]);
            }
        }
        dp[0][n-1]
    }
}