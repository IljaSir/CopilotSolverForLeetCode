impl Solution {
    pub fn length_of_lis(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        if n == 0 {
            return 0;
        }
        let mut dp = vec![1; n];
        let mut res = 1;
        for i in 1..n {
            for j in 0..i {
                if nums[i] > nums[j] {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            res = res.max(dp[i]);
        }
        res
    }
}