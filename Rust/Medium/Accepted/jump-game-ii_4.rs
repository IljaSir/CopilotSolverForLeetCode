impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut jump = 0;
        let mut start = 0;
        let mut end = 1;
        while end < nums.len() {
            let mut max_pos = 0;
            for i in start..end {
                max_pos = max_pos.max(i as i32 + nums[i]);
            }
            start = end;
            end = max_pos as usize + 1;
            jump += 1;
        }
        jump
    }
}