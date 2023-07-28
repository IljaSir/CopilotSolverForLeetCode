impl Solution {
    pub fn can_be_increasing(nums: Vec<i32>) -> bool {
        
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < nums.len() - 1 && nums[i] < nums[i + 1] {
            i += 1;
        }
        while j > 0 && nums[j - 1] < nums[j] {
            j -= 1;
        }
        if i == nums.len() - 1 || j == 0 {
            return true;
        }
        if i + 1 == j {
            return true;
        }
        if nums[i] < nums[j - 1] && nums[i + 1] > nums[j] {
            return false;
        }
        true
    }
}