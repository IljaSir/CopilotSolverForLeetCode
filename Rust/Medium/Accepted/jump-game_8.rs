impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        

        let mut max = 0;
        let n = nums.len();
        for i in 0..n {
            if i > max {
                return false;
            }
            max = max.max(nums[i] as usize + i);
        }
        true
    }
}