impl Solution {
    pub fn can_be_increasing(nums: Vec<i32>) -> bool {
        
        let mut count = 0;
        for i in 0..nums.len() - 1 {
            if nums[i] >= nums[i + 1] {
                count += 1;
                if count > 1 {
                    return false;
                }
                if i > 0 && nums[i - 1] >= nums[i + 1] && i + 2 < nums.len() && nums[i] >= nums[i + 2] {
                    return false;
                }
            }
        }
        true
    }
}