impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack = vec![];
        let mut k = k as usize;
        for i in 0..nums.len() {
            let n = nums[i];
            while !stack.is_empty() && stack.len() + nums.len() - i > k && stack[stack.len() - 1] < n {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(n);
            }
        }
        stack
    }
}