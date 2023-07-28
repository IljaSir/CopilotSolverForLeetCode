impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![0; nums.len()];
        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut idx = right;
        while left <= right {
            if nums[left].abs() > nums[right].abs() {
                result[idx] = nums[left].pow(2);
                left += 1;
            } else {
                result[idx] = nums[right].pow(2);
                right -= 1;
            }
            if idx == 0 {
                break;
            }
            idx -= 1;
        }
        result
    }
}