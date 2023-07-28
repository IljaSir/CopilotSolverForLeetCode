impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut max = nums[0];
        let mut min = nums[0];
        let mut total = nums[0];
        let mut max_sum = nums[0];
        let mut min_sum = nums[0];
        for i in 1..n {
            let num = nums[i];
            total += num;
            max_sum = max_sum.max(num);
            max_sum = max_sum.max(num + max_sum);
            min_sum = min_sum.min(num);
            min_sum = min_sum.min(num + min_sum);
            max = max.max(max_sum);
            min = min.min(min_sum);
        }
        if max > 0 {
            max.max(total - min)
        } else {
            max
        }
    }
}