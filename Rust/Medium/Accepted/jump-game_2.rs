impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        

        let mut max = 0;
        for i in 0..nums.len() {
            if i > max {
                return false;
            }
            max = std::cmp::max(max, nums[i] as usize + i);
        }
        true
    }
}