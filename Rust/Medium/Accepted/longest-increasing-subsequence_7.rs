impl Solution {
    pub fn length_of_lis(nums: Vec<i32>) -> i32 {
        

        if nums.is_empty() {
            return 0;
        }
        let mut dp = vec![0; nums.len()];
        dp[0] = 1;
        let mut max = 1;
        for i in 1..nums.len() {
            let mut max_val = 0;
            for j in 0..i {
                if nums[i] > nums[j] {
                    max_val = max_val.max(dp[j]);
                }
            }
            dp[i] = max_val + 1;
            max = max.max(dp[i]);
        }
        max
    }
}