impl Solution {
    pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut q = std::collections::VecDeque::new();
        let mut dp = vec![0; n];
        dp[0] = nums[0];
        q.push_back(0);
        for i in 1..n {
            while q.len() > 0 && q[0] < i as i32 - k {
                q.pop_front();
            }
            dp[i] = dp[q[0] as usize] + nums[i];
            while q.len() > 0 && dp[q[q.len() - 1] as usize] <= dp[i] {
                q.pop_back();
            }
            q.push_back(i as i32);
        }
        dp[n - 1]
    }
}