impl Solution {
    pub fn recover_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let k = nums[nums.len() / 2] - nums[0];
        nums.iter().map(|n| n - k).collect()
    }
}