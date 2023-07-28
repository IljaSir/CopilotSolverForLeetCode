impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut jump = 0;
        let mut end = 0;
        let mut farthest = 0;
        for i in 0..nums.len()-1 {
            farthest = farthest.max(nums[i] + i as i32);
            if i as i32 == end {
                jump += 1;
                end = farthest;
            }
        }
        jump
    }
}