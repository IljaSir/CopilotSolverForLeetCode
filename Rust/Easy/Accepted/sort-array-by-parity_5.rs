impl Solution {
    pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut left = 0;
        let mut right = nums.len() - 1;
        while left < right {
            if nums[left] % 2 == 0 {
                left += 1;
            } else if nums[right] % 2 == 1 {
                right -= 1;
            } else {
                nums.swap(left, right);
            }
        }
        nums
    }
}