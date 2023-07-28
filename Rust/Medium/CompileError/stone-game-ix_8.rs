impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        
        let n = stones.len();
        let mut dp = vec![vec![vec![0; 3]; 2]; n];
        dp[n-1][0][stones[n-1] % 3] = 1;
        dp[n-1][1][stones[n-1] % 3] = 1;
        for i in (0..n-1).rev() {
            for j in 0..3 {
                let a = (j + stones[i]) % 3;
                let b = (j + 2 * stones[i]) % 3;
                dp[i][0][j] = dp[i+1][1][a] | dp[i+1][1][b];
                dp[i][1][j] = dp[i+1][0][a] | dp[i+1][0][b];
            }
        }
        dp[0][0][0] == 1
    }
}