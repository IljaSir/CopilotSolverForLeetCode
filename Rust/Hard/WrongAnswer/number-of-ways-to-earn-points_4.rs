impl Solution {
    pub fn ways_to_reach_target(target: i32, types: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![0; (target + 1) as usize];
        dp[0] = 1;
        for type_ in types {
            for i in type_[1]..=target {
                dp[i as usize] += dp[(i - type_[1]) as usize];
            }
        }
        dp[target as usize]
    }
}