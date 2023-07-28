impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let mut res = 0;
        let mut prod = 1;
        let mut left = 0;
        for right in 0..nums.len() {
            prod *= nums[right] as i64;
            while prod >= k {
                prod /= nums[left] as i64;
                left += 1;
            }
            res += right - left + 1;
        }
        res as i64
    }
}