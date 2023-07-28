impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        let mut res = 0;
        let mut dp = 0;
        for i in 2..nums.len() {
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2] {
                dp += 1;
                res += dp;
            } else {
                dp = 0;
            }
        }
        res
    }
}