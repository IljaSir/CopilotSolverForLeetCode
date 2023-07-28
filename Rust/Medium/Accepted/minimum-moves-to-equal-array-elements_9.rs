impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let mut min = i32::MAX;
        let mut sum = 0;
        for i in nums.iter() {
            sum += i;
            if min > *i {
                min = *i;
            }
        }
        sum - min * nums.len() as i32
    }
}