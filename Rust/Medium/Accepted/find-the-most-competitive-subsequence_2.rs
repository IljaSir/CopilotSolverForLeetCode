impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut k = k;
        for i in 0..nums.len() {
            while stack.len() > 0 && nums[i] < stack[stack.len() - 1] && (k as usize) < (stack.len() + (nums.len() - i)) {
                stack.pop();
            }
            if stack.len() < k as usize {
                stack.push(nums[i]);
            }
        }
        stack
    }
}