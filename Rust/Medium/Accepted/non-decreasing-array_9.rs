impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        

        let mut changed = false;
        let mut last = i32::min_value();
        let mut i = 0;
        while i < nums.len() {
            if nums[i] < last {
                if changed {
                    return false;
                }
                changed = true;
                if i == 1 || nums[i - 2] <= nums[i] {
                    last = nums[i];
                }
            } else {
                last = nums[i];
            }
            i += 1;
        }
        true
    }
}