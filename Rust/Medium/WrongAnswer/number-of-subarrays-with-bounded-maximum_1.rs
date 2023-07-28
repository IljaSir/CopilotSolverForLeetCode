impl Solution {
    pub fn num_subarray_bounded_max(nums: Vec<i32>, left: i32, right: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        let mut res = 0;
        for i in 0..nums.len() {
            if nums[i] >= left && nums[i] <= right {
                if i == 0 {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
                res += dp[i];
            } else if nums[i] < left {
                if i > 0 {
                    dp[i] = dp[i - 1];
                    res += dp[i];
                }
            }
        }
        res
    }
}