impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut steps = 0;
        let mut i = 0;
        while i < nums.len() - 1 {
            let mut next_i = i + 1;
            let mut max_jump = nums[i] as usize;
            for j in 1..=nums[i] as usize {
                if i + j >= nums.len() - 1 {
                    return steps + 1;
                }
                if nums[i + j] as usize + j > max_jump {
                    max_jump = nums[i + j] as usize + j;
                    next_i = i + j;
                }
            }
            steps += 1;
            i = next_i;
        }
        steps
    }
}