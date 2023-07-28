impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = i32::max_value();
        for i in 0..nums.len() / 2 {
            res = res.min((nums[i] - nums[i + nums.len() / 2]).abs());
        }
        res
    }
}