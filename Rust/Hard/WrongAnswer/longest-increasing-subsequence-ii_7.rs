impl Solution {
    pub fn length_of_lis(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![1; nums.len()];
        let mut q = Vec::new();
        for i in 0..nums.len() {
            while let Some(&j) = q.last() {
                if nums[i] - nums[j] > k {
                    break;
                }
                dp[i] = std::cmp::max(dp[i], dp[j] + 1);
                q.pop();
            }
            q.push(i);
        }
        dp.into_iter().max().unwrap()
    }
}