impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        
        let n = piles.len();
        let mut dp = vec![vec![0; n]; n];
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + piles[i];
        }
        for i in (0..n).rev() {
            for m in 0..n {
                let mut x = 0;
                for j in (1..=2 * m).min(n - i) {
                    x = x.max(sum[i + j] - sum[i] - dp[i + j][j.max(m)]);
                }
                dp[i][m] = x;
            }
        }
        dp[0][1]
    }
}