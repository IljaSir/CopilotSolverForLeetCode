impl Solution {
    pub fn ways_to_reach_target(target: i32, types: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![0; target as usize + 1];
        dp[0] = 1;
        for type_ in types {
            for i in type_[1] as usize..=target as usize {
                dp[i] = (dp[i] + dp[i - type_[1] as usize]) % 1000000007;
            }
        }
        dp[target as usize]
    }
}