impl Solution {
    pub fn is_ideal_permutation(nums: Vec<i32>) -> bool {
        
        let mut max = nums[0];
        for i in 2..nums.len() {
            if max > nums[i] {
                return false;
            }
            max = max.max(nums[i - 1]);
        }
        true
    }
}