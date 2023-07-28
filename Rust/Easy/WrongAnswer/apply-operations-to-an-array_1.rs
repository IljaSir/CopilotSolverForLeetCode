impl Solution {
    pub fn apply_operations(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] == nums[i + 1] {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            i += 1;
        }
        nums.sort_by(|a, b| b.cmp(a));
        nums
    }
}