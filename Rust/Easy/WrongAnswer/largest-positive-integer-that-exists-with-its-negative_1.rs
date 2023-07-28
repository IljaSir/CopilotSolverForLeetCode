impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = nums.len() - 1;
        while i > 0 {
            if nums[i] == nums[i - 1] * -1 {
                return nums[i];
            }
            i -= 1;
        }
        -1
    }
}