impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut l = k as usize;
        let mut r = k as usize;
        let mut res = nums[k as usize];
        let mut min = nums[k as usize];
        while l > 0 || r < nums.len() - 1 {
            if l == 0 {
                r += 1;
            } else if r == nums.len() - 1 {
                l -= 1;
            } else if nums[l-1] > nums[r+1] {
                l -= 1;
            } else {
                r += 1;
            }
            min = min.min(nums[l].min(nums[r]));
            res = res.max(min * (r - l + 1) as i32);
        }
        res
    }
}