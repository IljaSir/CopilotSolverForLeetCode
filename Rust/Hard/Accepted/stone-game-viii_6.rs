impl Solution {
    pub fn stone_game_viii(stones: Vec<i32>) -> i32 {
        
        let mut acc = vec![0; stones.len()];
        acc[0] = stones[0];
        for i in 1..stones.len() {
            acc[i] = acc[i-1] + stones[i];
        }
        let mut dp = vec![0; stones.len()];
        dp[stones.len()-1] = acc[stones.len()-1];
        for i in (0..stones.len()-1).rev() {
            dp[i] = std::cmp::max(dp[i+1], acc[i] - dp[i+1]);
        }
        dp[1]
    }
}