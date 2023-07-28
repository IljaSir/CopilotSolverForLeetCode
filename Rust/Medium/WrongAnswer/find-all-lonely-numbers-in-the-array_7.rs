impl Solution {
    pub fn find_lonely(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        let mut i = 0;
        while i < nums.len() {
            if i == 0 && nums[i] != nums[i + 1] {
                result.push(nums[i]);
            } else if i == nums.len() - 1 && nums[i] != nums[i - 1] {
                result.push(nums[i]);
            } else if i > 0 && i < nums.len() - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1] {
                result.push(nums[i]);
            }
            i += 1;
        }
        result
    }
}