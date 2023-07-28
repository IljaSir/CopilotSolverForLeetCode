impl Solution {
    pub fn ways_to_reach_target(target: i32, types: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![0; target as usize + 1];
        dp[0] = 1;
        for i in 1..=target as usize {
            for t in &types {
                let (count, marks) = (t[0] as usize, t[1] as usize);
                if i >= marks {
                    dp[i] += dp[i - marks] * count;
                    dp[i] %= 1000000007;
                }
            }
        }
        dp[target as usize]
    }
}