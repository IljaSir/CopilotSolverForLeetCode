impl Solution {
    pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
        
        let m = dungeon.len();
        let n = dungeon[0].len();
        let mut dp = vec![vec![0; n]; m];
        dp[m - 1][n - 1] = (1 - dungeon[m - 1][n - 1]).max(1);
        for i in (0..m).rev() {
            for j in (0..n).rev() {
                if i == m - 1 && j == n - 1 {
                    continue;
                }
                if i == m - 1 {
                    dp[i][j] = (dp[i][j + 1] - dungeon[i][j]).max(1);
                }
                else if j == n - 1 {
                    dp[i][j] = (dp[i + 1][j] - dungeon[i][j]).max(1);
                }
                else {
                    dp[i][j] = ((dp[i + 1][j].min(dp[i][j + 1])) - dungeon[i][j]).max(1);
                }
            }
        }
        dp[0][0]
    }
}