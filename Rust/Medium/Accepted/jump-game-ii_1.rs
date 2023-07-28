impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut step = 0;
        let mut end = 0;
        let mut max_position = 0;
        for i in 0..nums.len() - 1 {
            max_position = max_position.max(i as i32 + nums[i]);
            if i as i32 == end {
                end = max_position;
                step += 1;
            }
        }
        step
    }
}