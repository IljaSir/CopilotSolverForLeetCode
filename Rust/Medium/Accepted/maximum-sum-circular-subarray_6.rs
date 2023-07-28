impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let mut max_sum = nums[0];
        let mut min_sum = nums[0];
        let mut total_sum = nums[0];
        let mut max = nums[0];
        let mut min = nums[0];
        for i in 1..nums.len() {
            let num = nums[i];
            max = std::cmp::max(max + num, num);
            min = std::cmp::min(min + num, num);
            max_sum = std::cmp::max(max_sum, max);
            min_sum = std::cmp::min(min_sum, min);
            total_sum += num;
        }
        if total_sum == min_sum {
            max_sum
        } else {
            std::cmp::max(max_sum, total_sum - min_sum)
        }
    }
}