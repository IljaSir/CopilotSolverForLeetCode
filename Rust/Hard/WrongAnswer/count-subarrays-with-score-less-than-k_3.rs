impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let mut res = 0;
        let mut p = 1;
        let mut i = 0;
        for j in 0..nums.len() {
            p *= nums[j] as i64;
            while p >= k {
                p /= nums[i] as i64;
                i += 1;
            }
            res += j - i + 1;
        }
        res as i64
    }
}