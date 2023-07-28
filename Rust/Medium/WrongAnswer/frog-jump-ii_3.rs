impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut max_jump = 0;
        for i in 1..stones.len() {
            max_jump = max_jump.max(stones[i] - stones[i-1]);
        }
        max_jump
    }
    pub fn min_cost(stones: Vec<i32>) -> i32 {
        let max_jump = Solution::max_jump(stones.clone());
        let mut dp = vec![vec![std::i32::MAX; stones.len()]; max_jump as usize + 1];
        dp[0][0] = 0;
        for i in 1..stones.len() {
            for j in 0..i {
                let jump = (stones[i] - stones[j]) as usize;
                if jump > max_jump as usize {
                    break;
                }
                for k in (1..=jump).rev() {
                    dp[k][i] = dp[k][i].min(dp[k-1][j]);
                }
            }
        }
        dp.into_iter().flatten().min().unwrap()
    }
}