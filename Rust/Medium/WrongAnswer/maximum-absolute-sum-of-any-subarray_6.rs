impl Solution {
    pub fn max_absolute_sum(nums: Vec<i32>) -> i32 {
        
        let mut max_sum = 0;
        let mut min_sum = 0;
        let mut max = 0;
        for i in nums {
            max_sum += i;
            min_sum += i;
            max = max.max(max_sum);
            max = max.max(min_sum);
            max_sum = max_sum.max(0);
            min_sum = min_sum.min(0);
        }
        max
    }
}