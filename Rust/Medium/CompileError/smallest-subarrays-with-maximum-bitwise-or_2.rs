impl Solution {
    pub fn smallest_subarrays(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut ans = vec![0; n];
        let mut stack = vec![];
        for i in 0..n {
            while !stack.is_empty() && stack[stack.len() - 1].1 <= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                let j = stack[stack.len() - 1].0;
                ans[j] = (i - j) as i32;
            }
            stack.push((i, nums[i]));
        }
        for j in 0..n {
            while !stack.is_empty() && stack[stack.len() - 1].1 <= nums[j] {
                stack.pop();
            }
            if !stack.is_empty() {
                let i = stack[stack.len() - 1].0;
                ans[j] = ans[j].min((i + n - j) as i32);
            }
            stack.push((j, nums[j]));
        }
        ans
    }
}