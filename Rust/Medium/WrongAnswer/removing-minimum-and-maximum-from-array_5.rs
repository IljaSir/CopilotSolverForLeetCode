impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let (mut l, mut r) = (0, n - 1);
        let (mut min, mut max) = (nums[0], nums[n - 1]);
        while l < r {
            if min < max {
                l += 1;
                min = min.max(nums[l]);
            } else {
                r -= 1;
                max = max.min(nums[r]);
            }
        }
        (l + n - r - 1) as i32
    }
}