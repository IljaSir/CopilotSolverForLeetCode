impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i] > max {
                max = nums[i];
            }
        }
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let mut result = sum;
        for i in 0..nums.len() {
            let temp = sum - max + nums[i];
            sum = temp;
            if temp < result {
                result = temp;
            }
        }
        result
    }
}