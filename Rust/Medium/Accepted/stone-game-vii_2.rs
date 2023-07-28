impl Solution {
    pub fn stone_game_vii(stones: Vec<i32>) -> i32 {
        
        let n = stones.len();
        let mut dp = vec![vec![0; n]; n];
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + stones[i];
        }
        for i in 1..n {
            for j in 0..n - i {
                let l = j;
                let r = i + j;
                dp[l][r] = (sum[r + 1] - sum[l + 1] - dp[l + 1][r]).max(sum[r] - sum[l] - dp[l][r - 1]);
            }
        }
        dp[0][n - 1]
    }
}