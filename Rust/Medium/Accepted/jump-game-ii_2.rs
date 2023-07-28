impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut jumps = 0;
        let mut cur_end = 0;
        let mut cur_farthest = 0;
        for i in 0..nums.len() - 1 {
            cur_farthest = cur_farthest.max(i as i32 + nums[i]);
            if i as i32 == cur_end {
                jumps += 1;
                cur_end = cur_farthest;
            }
        }
        jumps
    }
}