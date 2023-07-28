impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut sum = 0;
        for i in nums.iter() {
            sum += i;
        }
        let mut min = sum;
        nums.sort();
        let mut sum = 0;
        for i in 0..nums.len()-1 {
            sum += nums[i];
            if sum < min {
                min = sum;
            }
        }
        min
    }
}