impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![];
        let mut left = 0;
        let mut right = nums.len() - 1;
        while left <= right {
            if nums[left].abs() > nums[right].abs() {
                result.push(nums[left] * nums[left]);
                left += 1;
            } else {
                result.push(nums[right] * nums[right]);
                right -= 1;
            }
        }
        result.reverse();
        result
    }
}