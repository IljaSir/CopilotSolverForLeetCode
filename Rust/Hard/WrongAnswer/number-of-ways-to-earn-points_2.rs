impl Solution {
    pub fn ways_to_reach_target(target: i32, types: Vec<Vec<i32>>) -> i32 {
        
        let target = target as usize;
        let mut dp = vec![0; target + 1];
        dp[0] = 1;
        for t in types {
            for i in t[0] as usize..=target {
                dp[i] = (dp[i] + dp[i - t[0] as usize]) % 1000000007;
            }
        }
        dp[target]
    }
}