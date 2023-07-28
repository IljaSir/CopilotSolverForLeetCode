impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let mut min = nums[0];
        let mut sum = nums[0];
        for i in 1..nums.len() {
            if nums[i] < min {
                min = nums[i];
            }
            sum += nums[i];
        }
        (sum - min * nums.len() as i32) as i32
    }
}