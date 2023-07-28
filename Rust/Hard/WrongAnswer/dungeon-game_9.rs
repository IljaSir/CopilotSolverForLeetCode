impl Solution {
    pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
        
        let mut dp: Vec<Vec<i32>> = vec![vec![0; dungeon[0].len()]; dungeon.len()];
        for i in (0..dungeon.len()).rev() {
            for j in (0..dungeon[0].len()).rev() {
                if i == dungeon.len() - 1 && j == dungeon[0].len() - 1 {
                    dp[i][j] = dungeon[i][j].max(0) + 1;
                } else if i == dungeon.len() - 1 {
                    dp[i][j] = (dp[i][j + 1] - dungeon[i][j]).max(1);
                } else if j == dungeon[0].len() - 1 {
                    dp[i][j] = (dp[i + 1][j] - dungeon[i][j]).max(1);
                } else {
                    dp[i][j] = (dp[i + 1][j].min(dp[i][j + 1]) - dungeon[i][j]).max(1);
                }
            }
        }
        dp[0][0]
    }
}