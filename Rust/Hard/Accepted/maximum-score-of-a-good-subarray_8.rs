impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut min = nums[k];
        let mut max = min;
        let mut l = k;
        let mut r = k;
        let mut n = nums.len();
        while l > 0 || r < n-1 {
            if l == 0 {
                r += 1;
            } else if r == n-1 {
                l -= 1;
            } else if nums[l-1] < nums[r+1] {
                r += 1;
            } else {
                l -= 1;
            }
            if nums[l] < nums[r] {
                min = nums[l].min(min);
            } else {
                min = nums[r].min(min);
            }
            max = max.max(min * (r-l+1) as i32);
        }
        max
    }
}