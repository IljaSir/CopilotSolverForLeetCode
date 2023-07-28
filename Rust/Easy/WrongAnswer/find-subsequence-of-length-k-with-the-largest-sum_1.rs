impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = nums.len();
        let k = k as usize;
        let mut stack = Vec::with_capacity(k);
        let mut remain = n - k;
        for i in 0..n {
            while !stack.is_empty() && stack[stack.len() - 1] < nums[i] && remain > 0 {
                stack.pop();
                remain -= 1;
            }
            stack.push(nums[i]);
        }
        stack.truncate(k);
        stack
    }
}