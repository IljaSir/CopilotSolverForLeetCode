impl Solution {
    pub fn max_width_ramp(nums: Vec<i32>) -> i32 {
        
        let mut v = Vec::new();
        for (i, &n) in nums.iter().enumerate() {
            if v.is_empty() || nums[v[v.len() - 1]] > n {
                v.push(i);
            }
        }
        let mut ans = 0;
        for (i, &n) in nums.iter().rev().enumerate() {
            while !v.is_empty() && nums[v[v.len() - 1]] <= n {
                ans = std::cmp::max(ans, i as i32 + v[v.len() - 1] as i32);
                v.pop();
            }
        }
        ans
    }
}