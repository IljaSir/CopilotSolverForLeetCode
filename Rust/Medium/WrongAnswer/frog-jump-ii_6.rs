impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; stones.len()];
        for i in 1..stones.len() {
            dp[i] = stones[i] - stones[i-1];
            for j in 0..i {
                if stones[i] - stones[j] > dp[j] {
                    dp[i] = dp[i].max(dp[j] + stones[i] - stones[j]);
                }
            }
        }
        *dp.last().unwrap()
    }
}