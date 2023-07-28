impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let (mut max, mut min, mut sum, mut total) = (i32::MIN, i32::MAX, 0, 0);
        for &n in nums.iter() {
            sum = sum.max(0) + n;
            max = max.max(sum);
            total += n;
            sum = sum.min(0) + n;
            min = min.min(sum);
        }
        if max > 0 { max.max(total - min) } else { max }
    }
}