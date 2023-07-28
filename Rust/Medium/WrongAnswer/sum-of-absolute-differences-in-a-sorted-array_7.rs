impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let mut sum = 0;
        let mut sum2 = 0;
        let mut ans = vec![0; nums.len()];
        for i in 0..nums.len() {
            sum += nums[i];
            sum2 += nums[i] * i as i32;
        }
        for i in 0..nums.len() {
            ans[i] = nums[i] * (nums.len() as i32 - 1) - 2 * (sum - nums[i]) + sum2 - nums[i] * i as i32;
        }
        ans
    }
}