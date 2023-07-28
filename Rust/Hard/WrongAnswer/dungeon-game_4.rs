impl Solution {
    pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
        
        let m = dungeon.len();
        let n = dungeon[0].len();
        let mut dp = vec![vec![0; n]; m];
        dp[m-1][n-1] = dungeon[m-1][n-1].max(0) + 1;
        for i in (0..m).rev() {
            for j in (0..n).rev() {
                if i == m-1 && j == n-1 {
                    continue;
                }
                let mut right = i32::MAX;
                let mut down = i32::MAX;
                if i < m-1 {
                    right = dp[i+1][j];
                }
                if j < n-1 {
                    down = dp[i][j+1];
                }
                let min = right.min(down);
                dp[i][j] = min - dungeon[i][j];
                if dp[i][j] <= 0 {
                    dp[i][j] = 1;
                }
            }
        }
        dp[0][0]
    }
}