impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let mut max = std::i32::MIN;
        let mut min = std::i32::MAX;
        let mut max_sum = 0;
        let mut min_sum = 0;
        let mut sum = 0;
        for &n in &nums {
            max_sum = std::cmp::max(max_sum + n, n);
            min_sum = std::cmp::min(min_sum + n, n);
            max = std::cmp::max(max, max_sum);
            min = std::cmp::min(min, min_sum);
            sum += n;
        }
        if max > 0 { std::cmp::max(max, sum - min) } else { max }
    }
}