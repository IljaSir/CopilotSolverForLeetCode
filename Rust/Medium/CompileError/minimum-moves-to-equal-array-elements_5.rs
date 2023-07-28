impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let mut min = i32::max_value();
        let mut sum = 0;
        for i in nums {
            min = min.min(i);
            sum += i;
        }
        sum - min * nums.len() as i32
    }
}