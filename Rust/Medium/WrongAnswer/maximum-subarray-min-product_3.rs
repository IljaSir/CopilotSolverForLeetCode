impl Solution {
    pub fn max_sum_min_product(nums: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        let mut left = vec![0; nums.len()];
        let mut right = vec![nums.len(); nums.len()];
        let mut sum = vec![0; nums.len() + 1];
        let mut res = 0;
        for i in 0..nums.len() {
            while !stack.is_empty() && nums[*stack.last().unwrap()] >= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                left[i] = *stack.last().unwrap() + 1;
            }
            stack.push(i);
        }
        stack.clear();
        for i in (0..nums.len()).rev() {
            while !stack.is_empty() && nums[*stack.last().unwrap()] >= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                right[i] = *stack.last().unwrap();
            }
            stack.push(i);
        }
        for i in 0..nums.len() {
            sum[i + 1] = sum[i] + nums[i];
        }
        for i in 0..nums.len() {
            res = res.max(nums[i] * (sum[right[i]] - sum[left[i]]));
        }
        (res % 1000000007) as i32
    }
}