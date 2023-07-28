impl Solution {
    pub fn reduction_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        let mut i = nums.len() - 1;
        while i > 0 {
            if nums[i] != nums[i - 1] {
                count += nums.len() - i;
            }
            i -= 1;
        }
        count
    }
}