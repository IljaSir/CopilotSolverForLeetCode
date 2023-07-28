impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut k = k;
        for n in nums {
            while let Some(&top) = stack.last() {
                if n < top && stack.len() + nums.len() - 1 - nums.iter().position(|&x| x == n).unwrap() >= k as usize {
                    stack.pop();
                } else {
                    break;
                }
            }
            if stack.len() < k as usize {
                stack.push(n);
            }
        }
        stack
    }
}