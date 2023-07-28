impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let mut min = nums[0];
        for i in 1..nums.len() {
            if nums[i] < min {
                min = nums[i];
            }
        }
        let mut res = 0;
        for i in 0..nums.len() {
            res += nums[i] - min;
        }
        res
    }
}