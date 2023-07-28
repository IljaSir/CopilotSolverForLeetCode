impl Solution {
    pub fn ways_to_reach_target(target: i32, types: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![0; target as usize + 1];
        dp[0] = 1;
        for i in 1..=target {
            for j in 0..types.len() {
                let type_ = types[j].clone();
                if i >= type_[1] {
                    dp[i as usize] += dp[(i - type_[1]) as usize];
                    dp[i as usize] %= 1000000007;
                }
            }
        }
        dp[target as usize]
    }
}