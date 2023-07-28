impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let mut ans = 0;
        let mut p = 1;
        let mut l = 0;
        let mut r = 0;
        while r < nums.len() {
            p *= nums[r] as i64;
            while l <= r && p >= k {
                p /= nums[l] as i64;
                l += 1;
            }
            ans += r - l + 1;
            r += 1;
        }
        ans as i64
    }
}