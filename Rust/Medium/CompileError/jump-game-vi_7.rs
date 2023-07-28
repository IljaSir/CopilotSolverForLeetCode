impl Solution {
    pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        dp[0] = nums[0];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back(0);
        for i in 1..nums.len() {
            dp[i] = dp[*queue.front().unwrap()] + nums[i];
            while !queue.is_empty() && dp[i] >= dp[*queue.back().unwrap()] {
                queue.pop_back();
            }
            queue.push_back(i);
            if i as i32 - queue.front().unwrap() as i32 >= k {
                queue.pop_front();
            }
        }
        dp[nums.len() - 1]
    }
}