impl Solution {
    pub fn length_of_lis(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        let mut dp = vec![1; n];
        let mut res = 1;
        for i in 1..n {
            for j in 0..i {
                if nums[i] > nums[j] {
                    dp[i] = std::cmp::max(dp[i], dp[j] + 1);
                }
            }
            res = std::cmp::max(res, dp[i]);
        }
        res as i32
    }
}