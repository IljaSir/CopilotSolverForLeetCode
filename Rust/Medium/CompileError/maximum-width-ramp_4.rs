impl Solution {
    pub fn max_width_ramp(nums: Vec<i32>) -> i32 {
        
        let mut s = vec![];
        let mut ans = 0;
        for (i, n) in nums.iter().enumerate() {
            if s.is_empty() || nums[s.last().unwrap()] > *n {
                s.push(i);
            }
        }
        for (i, n) in nums.iter().enumerate().rev() {
            while let Some(&j) = s.last() {
                if nums[j] > *n {
                    break;
                }
                ans = ans.max(j - i);
                s.pop();
            }
        }
        ans as i32
    }
}