impl Solution {
    pub fn min_start_value(nums: Vec<i32>) -> i32 {
        
        let mut min = 0;
        let mut sum = 0;
        for i in nums {
            sum += i;
            if sum < min {
                min = sum;
            }
        }
        return 1 - min;
    }
}