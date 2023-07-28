impl Solution {
    pub fn stone_game_viii(stones: Vec<i32>) -> i32 {
        
        let n = stones.len();
        let mut dp = vec![0; n];
        dp[n-1] = stones[n-1];
        for i in (0..n-1).rev() {
            dp[i] = dp[i+1] + stones[i];
        }
        let mut res = dp[1];
        for i in 2..n {
            res = res.max(dp[i]);
        }
        res
    }
}