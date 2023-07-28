impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        nums.dedup();
        if nums.len() < 3 {
            return nums[nums.len() - 1];
        } else {
            return nums[nums.len() - 3];
        }
    }
}