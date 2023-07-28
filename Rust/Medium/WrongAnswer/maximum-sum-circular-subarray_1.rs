impl Solution {
    pub fn max_subarray_sum_circular(nums: Vec<i32>) -> i32 {
        
        let mut max = nums[0];
        let mut min = nums[0];
        let mut max_sum = nums[0];
        let mut min_sum = nums[0];
        let mut sum = nums[0];
        for i in 1..nums.len() {
            let num = nums[i];
            if sum < 0 {
                sum = num;
            } else {
                sum = sum + num;
            }
            if max_sum < sum {
                max_sum = sum;
            }
            if sum > 0 {
                sum = num;
            } else {
                sum = sum + num;
            }
            if min_sum > sum {
                min_sum = sum;
            }
        }
        let sum: i32 = nums.iter().sum();
        let mut ans = max_sum;
        if sum - min_sum > ans {
            ans = sum - min_sum;
        }
        if sum == min_sum {
            ans = max;
        }
        ans
    }
}