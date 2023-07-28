impl Solution {
    pub fn is_ideal_permutation(nums: Vec<i32>) -> bool {
        
        let mut max = 0;
        for i in 0..nums.len() - 2 {
            max = std::cmp::max(max, nums[i]);
            if max > nums[i + 2] {
                return false;
            }
        }
        true
    }
}