impl Solution {
    pub fn minimum_difference(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let k = k as usize;
        nums.sort();
        let mut min = std::i32::MAX;
        for i in 0..=(nums.len() - k) {
            min = min.min(nums[i + k - 1] - nums[i]);
        }
        min
    }
}