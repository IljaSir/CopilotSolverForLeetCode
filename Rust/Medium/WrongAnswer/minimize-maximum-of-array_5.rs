impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut min = i32::MAX;
        let mut sum = 0;
        for i in 0..nums.len()-1 {
            sum += nums[i];
            min = min.min(nums[i+1] - sum);
        }
        nums[nums.len()-1] - sum
    }
}