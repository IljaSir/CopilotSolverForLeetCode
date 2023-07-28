impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let mut min = i32::max_value();
        for n in nums {
            if n < min {
                min = n;
            }
        }
        let mut result = 0;
        for n in nums {
            result += n - min;
        }
        result
    }
}