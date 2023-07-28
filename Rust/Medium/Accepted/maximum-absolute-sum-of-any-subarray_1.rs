impl Solution {
    pub fn max_absolute_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut min = 0;
        let mut sum = 0;
        for n in nums {
            sum += n;
            max = max.max(sum);
            min = min.min(sum);
        }
        max - min
    }
}