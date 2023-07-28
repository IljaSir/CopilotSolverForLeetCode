impl Solution {
    pub fn largest_number(cost: Vec<i32>, target: i32) -> String {
        
        let mut dp = vec![0; target as usize + 1];
        for i in 0..target as usize {
            if dp[i] == 0 && i != 0 {
                continue;
            }
            for j in 0..9 {
                let c = cost[j];
                if i + c as usize > target as usize {
                    continue;
                }
                dp[i + c as usize] = std::cmp::max(dp[i + c as usize], dp[i] * 10 + j as i32 + 1);
            }
        }
        if dp[target as usize] == 0 {
            return "0".to_string();
        }
        dp[target as usize].to_string()
    }
}