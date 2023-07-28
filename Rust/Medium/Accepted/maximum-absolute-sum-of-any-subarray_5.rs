impl Solution {
    pub fn max_absolute_sum(nums: Vec<i32>) -> i32 {
        
        let mut max_sum = 0;
        let mut min_sum = 0;
        let mut max = 0;
        let mut min = 0;
        for i in 0..nums.len() {
            max_sum += nums[i];
            min_sum += nums[i];
            if max_sum < 0 {
                max_sum = 0;
            }
            if min_sum > 0 {
                min_sum = 0;
            }
            if max_sum > max {
                max = max_sum;
            }
            if min_sum < min {
                min = min_sum;
            }
        }
        if max > -min {
            max
        } else {
            -min
        }
    }
}