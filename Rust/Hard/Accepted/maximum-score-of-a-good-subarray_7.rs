impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut res = nums[k];
        let mut l = k as i32;
        let mut r = k as i32;
        let mut min_num = nums[k];
        while l > 0 || r < nums.len() as i32 - 1 {
            if (l == 0) || (r < nums.len() as i32 - 1 && nums[l as usize - 1] < nums[r as usize + 1]) {
                r += 1;
                min_num = min_num.min(nums[r as usize]);
            } else {
                l -= 1;
                min_num = min_num.min(nums[l as usize]);
            }
            res = res.max(min_num * (r - l + 1));
        }
        res
    }
}