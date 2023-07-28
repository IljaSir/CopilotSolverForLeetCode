impl Solution {
    pub fn ways_to_reach_target(target: i32, types: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![0; target as usize + 1];
        dp[0] = 1;
        for t in types {
            for i in t[1]..=target {
                dp[i as usize] = (dp[i as usize] + dp[(i-t[1]) as usize]) % 1000000007;
            }
        }
        dp[target as usize]
    }
}