impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        let k = k as usize;
        let mut i = 0;
        while i < nums.len() {
            while !stack.is_empty() && stack[stack.len() - 1] > nums[i] && stack.len() - 1 + nums.len() - i >= k {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(nums[i]);
            }
            i += 1;
        }
        stack
    }
}