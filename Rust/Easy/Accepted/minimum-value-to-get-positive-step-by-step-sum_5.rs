impl Solution {
    pub fn min_start_value(nums: Vec<i32>) -> i32 {
        
        let mut min = 0;
        let mut sum = 0;
        for num in nums {
            sum += num;
            min = std::cmp::min(min, sum);
        }
        1 - min
    }
}