impl Solution {
    pub fn stone_game_viii(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; stones.len()];
        dp[0] = stones[0];
        for i in 1..stones.len() {
            dp[i] = dp[i - 1] + stones[i];
        }
        let mut ans = dp[stones.len() - 1];
        for i in 1..stones.len() - 1 {
            ans = ans.max(dp[i] - ans);
        }
        ans
    }
}