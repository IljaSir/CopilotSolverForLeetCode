impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let (mut max_sum, mut min_sum, mut cur_max, mut cur_min, mut sum) = (nums[0], nums[0], 0, 0, 0);
        for &num in nums.iter() {
            cur_max = cur_max.max(0) + num;
            max_sum = max_sum.max(cur_max);
            cur_min = cur_min.min(0) + num;
            min_sum = min_sum.min(cur_min);
            sum += num;
        }
        if max_sum > 0 { max_sum.max(sum - min_sum) } else { max_sum }
    }
}