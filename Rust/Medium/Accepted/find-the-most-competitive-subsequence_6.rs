impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack = vec![];
        let mut k = k;
        for (i, &n) in nums.iter().enumerate() {
            while !stack.is_empty() && stack.last().unwrap() > &n && stack.len() + nums.len() - i > k as usize {
                stack.pop();
            }
            if stack.len() < k as usize {
                stack.push(n);
            }
        }
        stack
    }
}