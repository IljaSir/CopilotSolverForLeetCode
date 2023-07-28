impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut max_sum = nums[0];
        let mut min_sum = nums[0];
        let mut cur_max = nums[0];
        let mut cur_min = nums[0];
        let mut total = nums[0];
        for i in 1..n {
            cur_max = cur_max.max(0) + nums[i];
            max_sum = max_sum.max(cur_max);
            cur_min = cur_min.min(0) + nums[i];
            min_sum = min_sum.min(cur_min);
            total += nums[i];
        }
        if max_sum > 0 {
            max_sum.max(total - min_sum)
        } else {
            max_sum
        }
    }
}