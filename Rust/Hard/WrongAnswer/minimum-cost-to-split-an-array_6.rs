impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        let mut cost = vec![0; nums.len()];
        let mut count = vec![0; nums.len()];
        let mut freq = vec![0; nums.len()];
        for i in 0..nums.len() {
            count[nums[i] as usize] += 1;
            cost[i] = cost[i.saturating_sub(1)] + if count[nums[i] as usize] == 1 { 1 } else { 0 };
            freq[i] = freq[i.saturating_sub(1)] + if count[nums[i] as usize] == 1 { 0 } else { 1 };
        }
        for i in 1..k as usize {
            let mut stack = Vec::new();
            for j in 0..nums.len() {
                while let Some(&k) = stack.last() {
                    if dp[k] + freq[j] - freq[k] <= dp[j] + freq[j] - freq[j] {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                dp[j] = dp[stack.last().copied().unwrap_or(0)] + freq[j] - freq[stack.last().copied().unwrap_or(0)];
                stack.push(j);
            }
        }
        dp[nums.len() - 1] as i32 + cost[nums.len() - 1] * k
    }
}