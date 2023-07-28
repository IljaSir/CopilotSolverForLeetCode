impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack = vec![];
        let n = nums.len();
        let k = k as usize;
        for (i, &num) in nums.iter().enumerate() {
            while !stack.is_empty() && stack.last().unwrap() > &num && n - i + stack.len() > k {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(num);
            }
        }
        stack
    }
}