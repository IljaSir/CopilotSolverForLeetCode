impl Solution {
    pub fn can_be_increasing(nums: Vec<i32>) -> bool {
        
        let mut v = 0;
        for i in 1..nums.len() {
            if nums[i - 1] >= nums[i] {
                v += 1;
                if v > 1 {
                    return false;
                }
                if i > 1 && i < nums.len() - 1 && nums[i - 2] >= nums[i] && nums[i - 1] >= nums[i + 1] {
                    return false;
                }
            }
        }
        true
    }
}