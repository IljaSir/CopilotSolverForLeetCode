impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut l = k;
        let mut r = k;
        let mut min = nums[k];
        let mut res = min;
        while l > 0 || r < nums.len() - 1 {
            let a = if l == 0 { 0 } else { nums[l - 1] };
            let b = if r == nums.len() - 1 { 0 } else { nums[r + 1] };
            if a >= b {
                l -= 1;
            } else {
                r += 1;
            }
            min = std::cmp::min(min, nums[l].min(nums[r]));
            res = std::cmp::max(res, min * (r - l + 1) as i32);
        }
        res
    }
}