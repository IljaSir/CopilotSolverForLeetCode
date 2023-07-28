impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut sum = 0;
        for n in nums.iter() {
            sum += n;
        }
        let mut min = sum;
        let mut cur = sum;
        nums.sort();
        for i in 1..nums.len() {
            cur += nums[i] - nums[i - 1];
            min = min.min(cur);
        }
        min
    }
}