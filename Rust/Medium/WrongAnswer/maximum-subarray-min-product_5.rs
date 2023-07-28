impl Solution {
    pub fn max_sum_min_product(nums: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        let mut left = vec![0; nums.len()];
        let mut right = vec![nums.len(); nums.len()];
        let mut sum = vec![0; nums.len()];
        for i in 0..nums.len() {
            while !stack.is_empty() && nums[stack[stack.len() - 1]] >= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                left[i] = stack[stack.len() - 1] + 1;
            }
            stack.push(i);
        }
        stack.clear();
        for i in (0..nums.len()).rev() {
            while !stack.is_empty() && nums[stack[stack.len() - 1]] >= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                right[i] = stack[stack.len() - 1];
            }
            stack.push(i);
        }
        for i in 0..nums.len() {
            sum[i] = nums[i];
            sum[i] += if i > 0 { sum[i - 1] } else { 0 };
        }
        let mut result = 0;
        for i in 0..nums.len() {
            let s = sum[right[i] - 1] - sum[left[i]] + nums[left[i]];
            result = result.max(nums[i] * s);
        }
        (result % 1000000007) as i32
    }
}