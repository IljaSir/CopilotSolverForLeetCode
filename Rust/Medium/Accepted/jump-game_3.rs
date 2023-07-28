impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        

        let mut max_pos = 0;
        for i in 0..nums.len() {
            if i > max_pos {
                return false;
            }
            max_pos = max_pos.max(i + nums[i] as usize);
        }
        true
    }
}