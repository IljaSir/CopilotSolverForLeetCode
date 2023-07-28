impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let mut res = nums[0];
        let mut cur = nums[0];
        for i in 1..nums.len() {
            cur = nums[i].max(nums[i] + cur);
            res = res.max(cur);
        }
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let mut min_sum = 0;
        let mut min_cur = 0;
        for i in 0..nums.len() {
            min_cur = (nums[i] + min_cur).min(nums[i]);
            min_sum = min_sum.min(min_cur);
        }
        if sum == min_sum {
            return res;
        }
        res.max(sum - min_sum)
    }
}