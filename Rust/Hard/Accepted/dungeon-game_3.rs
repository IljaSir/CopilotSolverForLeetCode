impl Solution {
    pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
        
        let m = dungeon.len();
        let n = dungeon[0].len();
        let mut dp = vec![vec![std::i32::MAX; n+1]; m+1];
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        for i in (0..m).rev() {
            for j in (0..n).rev() {
                let need = (dp[i+1][j].min(dp[i][j+1]) - dungeon[i][j]).max(1);
                dp[i][j] = need;
            }
        }
        dp[0][0]
    }
}