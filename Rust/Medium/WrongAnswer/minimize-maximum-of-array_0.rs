impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        for i in 1..nums.len() {
            sum += nums[i] - nums[0];
        }
        sum
    }
}