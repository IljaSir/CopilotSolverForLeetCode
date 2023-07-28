impl Solution {
    pub fn min_side_jumps(obstacles: Vec<i32>) -> i32 {
        
        let mut dp = [1, 0, 1];
        for o in obstacles {
            if o > 0 {
                dp[o as usize - 1] = 5_000_000;
            }
            for i in 0..3 {
                if i + 1 != o as usize {
                    dp[i] = dp[i].min(dp[(i + 1) % 3].min(dp[(i + 2) % 3]) + 1);
                }
            }
        }
        dp[1]
    }
}