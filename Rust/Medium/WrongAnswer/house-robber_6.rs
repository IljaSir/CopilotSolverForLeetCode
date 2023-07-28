impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let mut dp: Vec<i32> = vec![0; nums.len()];
        for i in 0..nums.len() {
            let mut max = 0;
            for j in 0..i {
                if dp[j] > max {
                    max = dp[j];
                }
            }
            dp[i] = max + nums[i];
        }
        let mut max = 0;
        for i in 0..dp.len() {
            if dp[i] > max {
                max = dp[i];
            }
        }
        max
    }
}