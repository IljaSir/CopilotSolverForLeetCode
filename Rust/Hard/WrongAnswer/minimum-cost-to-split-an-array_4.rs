impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = vec![0;nums.len()];
        for i in nums.iter() {
            count[*i as usize] += 1;
        }
        let mut trimmed = vec![];
        for i in count.iter() {
            if *i > 1 {
                trimmed.push(*i);
            }
        }
        let mut dp = vec![vec![0;trimmed.len()+1];k as usize+1];
        for i in 0..trimmed.len() {
            dp[1][i+1] = trimmed[i] + dp[1][i];
        }
        for i in 2..k as usize+1 {
            for j in i..trimmed.len()+1 {
                let mut min = std::i32::MAX;
                for m in i-1..j {
                    min = std::cmp::min(min,dp[i-1][m]+dp[1][j]-dp[1][m]);
                }
                dp[i][j] = min;
            }
        }
        dp[k as usize][trimmed.len()]
    }
}