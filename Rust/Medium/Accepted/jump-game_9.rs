impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        

        let mut pos = 0;
        let mut max = 0;
        while pos < nums.len() {
            if pos > max {
                return false;
            }
            max = std::cmp::max(max, pos + nums[pos] as usize);
            if max >= nums.len() - 1 {
                return true;
            }
            pos += 1;
        }
        false
    }
}