impl Solution {
    pub fn num_moves_stones(a: i32, b: i32, c: i32) -> Vec<i32> {
        
        let mut nums = vec![a, b, c];
        nums.sort();
        let mut min = 2;
        if nums[2] - nums[1] <= 2 || nums[1] - nums[0] <= 2 {
            min = 1;
        }
        if nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1 {
            min = 0;
        }
        let max = nums[2] - nums[1] - 1 + nums[1] - nums[0] - 1;
        vec![min, max]
    }
}