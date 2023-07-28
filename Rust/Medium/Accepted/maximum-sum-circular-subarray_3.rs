impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let mut max_sum = nums[0];
        let mut min_sum = nums[0];
        let mut total_sum = nums[0];
        let mut curr_max = nums[0];
        let mut curr_min = nums[0];
        for i in 1..nums.len() {
            total_sum += nums[i];
            curr_max = nums[i].max(curr_max + nums[i]);
            curr_min = nums[i].min(curr_min + nums[i]);
            max_sum = max_sum.max(curr_max);
            min_sum = min_sum.min(curr_min);
        }
        if max_sum > 0 {
            max_sum.max(total_sum - min_sum)
        } else {
            max_sum
        }
    }
}