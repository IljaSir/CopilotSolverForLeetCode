impl Solution {
    pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
        
        let m = dungeon.len();
        let n = dungeon[0].len();
        let mut dp = vec![vec![0; n]; m];
        dp[m-1][n-1] = if dungeon[m-1][n-1] > 0 { 1 } else { 1 - dungeon[m-1][n-1] };
        for i in (0..m-1).rev() {
            dp[i][n-1] = if dp[i+1][n-1] > dungeon[i][n-1] { dp[i+1][n-1] - dungeon[i][n-1] } else { 1 };
        }
        for j in (0..n-1).rev() {
            dp[m-1][j] = if dp[m-1][j+1] > dungeon[m-1][j] { dp[m-1][j+1] - dungeon[m-1][j] } else { 1 };
        }
        for i in (0..m-1).rev() {
            for j in (0..n-1).rev() {
                dp[i][j] = if dp[i+1][j] < dp[i][j+1] {
                    if dp[i+1][j] > dungeon[i][j] { dp[i+1][j] - dungeon[i][j] } else { 1 }
                } else {
                    if dp[i][j+1] > dungeon[i][j] { dp[i][j+1] - dungeon[i][j] } else { 1 }
                };
            }
        }
        dp[0][0]
    }
}