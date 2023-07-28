impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut res = nums[k];
        let mut l = k;
        let mut r = k;
        let mut min = nums[k];
        while l > 0 || r < nums.len() - 1 {
            if l == 0 {
                r += 1;
            } else if r == nums.len() - 1 {
                l -= 1;
            } else {
                if nums[l - 1] >= nums[r + 1] {
                    l -= 1;
                } else {
                    r += 1;
                }
            }
            min = min.min(nums[l].min(nums[r]));
            res = res.max(min * (r - l + 1) as i32);
        }
        res
    }
}