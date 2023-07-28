impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut stack = vec![];
        let mut res = 0;
        let mut k = k as usize;
        let mut nums = nums;
        nums.push(0);
        for i in 0..nums.len() {
            while !stack.is_empty() && nums[*stack.last().unwrap()] >= nums[i] {
                let j = stack.pop().unwrap();
                let left = if stack.is_empty() { 0 } else { *stack.last().unwrap() + 1 };
                let right = i - 1;
                if left <= k && k <= right {
                    res = res.max(nums[j] * (right - left + 1) as i32);
                }
            }
            stack.push(i);
        }
        res
    }
}