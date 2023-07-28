impl Solution {
    pub fn max_absolute_sum(nums: Vec<i32>) -> i32 {
        
        let mut max_positive = 0;
        let mut min_negative = 0;
        let mut max_absolute_sum = 0;
        for i in 0..nums.len() {
            let v = nums[i];
            max_positive = std::cmp::max(max_positive + v, v);
            min_negative = std::cmp::min(min_negative + v, v);
            max_absolute_sum = std::cmp::max(max_absolute_sum, std::cmp::max(max_positive, -min_negative));
        }
        max_absolute_sum
    }
}