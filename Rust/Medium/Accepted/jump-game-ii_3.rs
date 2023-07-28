impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut steps = 0;
        let mut end = 0;
        let mut max_pos = 0;
        for i in 0..nums.len() - 1 {
            max_pos = max_pos.max(i as i32 + nums[i]);
            if i as i32 == end {
                end = max_pos;
                steps += 1;
            }
        }
        steps
    }
}