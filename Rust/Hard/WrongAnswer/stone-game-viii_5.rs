impl Solution {
    pub fn stone_game_viii(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; stones.len()];
        dp[1] = stones[0] + stones[1];
        for i in 2..stones.len() {
            dp[i] = dp[i - 1] + stones[i];
        }
        let mut best = dp[stones.len() - 1];
        for i in (2..stones.len() - 1).rev() {
            best = best.max(dp[i] - best);
        }
        best
    }
}