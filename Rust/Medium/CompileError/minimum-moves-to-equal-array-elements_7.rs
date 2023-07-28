impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut min = i32::MAX;
        for num in nums {
            sum += num;
            if num < min {
                min = num;
            }
        }
        sum - (nums.len() as i32) * min
    }
}