impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let mut max = nums[0];
        let mut min = nums[0];
        let mut sum = 0;
        let mut max_sum = nums[0];
        let mut min_sum = nums[0];
        for &n in nums.iter() {
            sum += n;
            if max_sum > 0 {
                max_sum = n;
            } else {
                max_sum += n;
            }
            if max_sum > max {
                max = max_sum;
            }
            if min_sum < 0 {
                min_sum = n;
            } else {
                min_sum += n;
            }
            if min_sum < min {
                min = min_sum;
            }
        }
        if max < 0 {
            max
        } else {
            std::cmp::max(max, sum - min)
        }
    }
}