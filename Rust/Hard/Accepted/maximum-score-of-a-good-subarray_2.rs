impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut l = k as usize;
        let mut r = k as usize;
        let mut res = nums[k as usize];
        let mut min = nums[k as usize];
        while l > 0 || r < n - 1 {
            if (l == 0) || (r < n - 1 && nums[l - 1] < nums[r + 1]) {
                r += 1;
                min = min.min(nums[r]);
            } else {
                l -= 1;
                min = min.min(nums[l]);
            }
            res = res.max(min * (r - l + 1) as i32);
        }
        res
    }
}