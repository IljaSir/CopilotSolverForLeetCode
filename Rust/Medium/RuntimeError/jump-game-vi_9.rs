impl Solution {
    pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        let mut q: Vec<usize> = vec![];
        dp[0] = nums[0];
        q.push(0);
        for i in 1..nums.len() {
            while q.len() > 0 && q[0] < i - k as usize {
                q.remove(0);
            }
            dp[i] = dp[q[0]] + nums[i];
            while q.len() > 0 && dp[q[q.len() - 1]] <= dp[i] {
                q.pop();
            }
            q.push(i);
        }
        dp[nums.len() - 1]
    }
}