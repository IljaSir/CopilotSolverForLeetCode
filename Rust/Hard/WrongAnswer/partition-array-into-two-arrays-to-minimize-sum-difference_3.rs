impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        let n = nums.len();
        for i in 0..n/2 {
            sum += nums[i+n/2] - nums[i];
        }
        sum
    }
}