impl Solution {
    pub fn minimum_difference(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut min = std::i32::MAX;
        for i in 0..nums.len() - k as usize + 1 {
            let diff = nums[i + k as usize - 1] - nums[i];
            if diff < min {
                min = diff;
            }
        }
        min
    }
}