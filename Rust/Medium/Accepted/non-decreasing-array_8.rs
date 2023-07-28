impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        

        let mut modified = false;
        let mut last = i32::MIN;
        for i in 0..nums.len() {
            if last > nums[i] {
                if modified {
                    return false;
                }
                modified = true;
                if i == 1 || nums[i - 2] <= nums[i] {
                    last = nums[i];
                }
            } else {
                last = nums[i];
            }
        }
        true
    }
}