impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        

        let mut max = 0;
        for i in 0..nums.len() {
            if i <= max {
                max = max.max(i + nums[i] as usize);
                if max >= nums.len() - 1 {
                    return true;
                }
            }
        }
        false
    }
}