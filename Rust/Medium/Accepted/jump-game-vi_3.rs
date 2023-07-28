impl Solution {
    pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        dp[0] = nums[0];
        let mut q = std::collections::VecDeque::new();
        q.push_back(0);
        for i in 1..nums.len() {
            while let Some(&j) = q.front() {
                if i as i32 - j as i32 > k {
                    q.pop_front();
                } else {
                    break;
                }
            }
            dp[i] = dp[q[0]] + nums[i];
            while let Some(&j) = q.back() {
                if dp[j] <= dp[i] {
                    q.pop_back();
                } else {
                    break;
                }
            }
            q.push_back(i);
        }
        dp[nums.len() - 1]
    }
}