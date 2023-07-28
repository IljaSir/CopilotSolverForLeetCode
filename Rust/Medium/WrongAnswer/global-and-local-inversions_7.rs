impl Solution {
    pub fn is_ideal_permutation(nums: Vec<i32>) -> bool {
        
        let mut min = std::i32::MAX;
        for i in (0..nums.len()).rev() {
            if nums[i] < min {
                min = nums[i];
            } else if nums[i] > min {
                return false;
            }
        }
        true
    }
}