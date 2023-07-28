impl Solution {
    pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        let mut q = std::collections::VecDeque::new();
        dp[0] = nums[0];
        q.push_back(0);
        for i in 1..nums.len() {
            while q.len() > 0 && q[0] < i as i32 - k {
                q.pop_front();
            }
            dp[i] = nums[i] + dp[q[0] as usize];
            while q.len() > 0 && dp[q.back().unwrap() as usize] < dp[i] {
                q.pop_back();
            }
            q.push_back(i as i32);
        }
        dp[nums.len() - 1]
    }
}