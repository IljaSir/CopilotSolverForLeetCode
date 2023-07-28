impl Solution {
    pub fn ways_to_reach_target(target: i32, types: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![0; (target + 1) as usize];
        dp[0] = 1;
        for type_ in types {
            for j in 0..=target {
                if j + type_[1] <= target {
                    dp[(j + type_[1]) as usize] += dp[j as usize] * type_[0];
                    dp[(j + type_[1]) as usize] %= 1000000007;
                }
            }
        }
        dp[target as usize]
    }
}