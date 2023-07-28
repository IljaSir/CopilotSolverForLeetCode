impl Solution {
    pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![0; n];
        dp[0] = nums[0];
        let mut q = std::collections::VecDeque::new();
        q.push_back(0);
        for i in 1..n {
            dp[i] = dp[*q.front().unwrap()] + nums[i];
            while !q.is_empty() && dp[i] >= dp[*q.back().unwrap()] {
                q.pop_back();
            }
            q.push_back(i);
            if i as i32 - q.front().unwrap() as i32 >= k {
                q.pop_front();
            }
        }
        dp[n - 1]
    }
}