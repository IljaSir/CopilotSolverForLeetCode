impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        

        let mut far = 0;
        for i in 0..nums.len() {
            if far < i {
                return false;
            }
            far = far.max(i + nums[i] as usize);
        }
        true
    }
}