impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let (mut l, mut r, mut sum, mut res) = (0, 0, 0, 0);
        while r < nums.len() {
            sum += nums[r] as i64;
            while l <= r && sum * (r - l + 1) as i64 >= k {
                sum -= nums[l] as i64;
                l += 1;
            }
            res += r - l + 1;
            r += 1;
        }
        res as i64
    }
}