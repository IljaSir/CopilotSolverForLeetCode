impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut k = k as usize;
        let mut stack = Vec::new();
        for (i, &num) in nums.iter().enumerate() {
            while !stack.is_empty() && stack[stack.len() - 1] > num && nums.len() - i + stack.len() > k {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(num);
            }
        }
        stack
    }
}